import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

class playmusic extends Thread {       //定义一个音乐类，用来播放音乐

	private String wjm;           //文件名
	public playmusic(String ypwj)       //给声音传进音频文件的方法
	{
		 wjm=ypwj;              //音频文件的音频赋给文件名
	}

	public void run() {                

		File wjl = new File(wjm);        //文件流

		AudioInputStream ypsrl = null;        //音频输入流
		try {
			ypsrl = AudioSystem.getAudioInputStream(wjl);    
		} catch (Exception e){
			e.printStackTrace();
		}
		AudioFormat format = ypsrl.getFormat();  //音频格式处理
		SourceDataLine aqsj = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);    //一个数据一个数据（码）进行处理

		try {
			aqsj = (SourceDataLine) AudioSystem.getLine(info);   //安全性包装
			aqsj.open(format);
		} catch (Exception e){}		
		aqsj.start();
		
		int zjtj = 0;
		byte[] hczj = new byte[1024];          //缓冲字节
		try {
			while (zjtj  != -1) {              
				zjtj = ypsrl.read(hczj, 0, hczj.length);
				if (zjtj  >= 0)
					aqsj.write(hczj, 0, zjtj );
			}
		} catch (Exception e){}
		finally {
			aqsj.drain();//将残留部分处理干净
			aqsj.close();
		}
	}	
}

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

class playmusic extends Thread {       //����һ�������࣬������������

	private String wjm;           //�ļ���
	public playmusic(String ypwj)       //������������Ƶ�ļ��ķ���
	{
		 wjm=ypwj;              //��Ƶ�ļ�����Ƶ�����ļ���
	}

	public void run() {                

		File wjl = new File(wjm);        //�ļ���

		AudioInputStream ypsrl = null;        //��Ƶ������
		try {
			ypsrl = AudioSystem.getAudioInputStream(wjl);    
		} catch (Exception e){
			e.printStackTrace();
		}
		AudioFormat format = ypsrl.getFormat();  //��Ƶ��ʽ����
		SourceDataLine aqsj = null;
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);    //һ������һ�����ݣ��룩���д���

		try {
			aqsj = (SourceDataLine) AudioSystem.getLine(info);   //��ȫ�԰�װ
			aqsj.open(format);
		} catch (Exception e){}		
		aqsj.start();
		
		int zjtj = 0;
		byte[] hczj = new byte[1024];          //�����ֽ�
		try {
			while (zjtj  != -1) {              
				zjtj = ypsrl.read(hczj, 0, hczj.length);
				if (zjtj  >= 0)
					aqsj.write(hczj, 0, zjtj );
			}
		} catch (Exception e){}
		finally {
			aqsj.drain();//���������ִ���ɾ�
			aqsj.close();
		}
	}	
}

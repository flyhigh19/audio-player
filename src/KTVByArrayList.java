import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class KTVByArrayList{
	public static void main(String[] args) {
		System.out.println("-------------欢迎来到点歌系统------------");
		System.out.println("0.添加歌曲至列表");
		System.out.println("1.将歌曲置顶");
		System.out.println("2.将歌曲前移一位");
		System.out.println("3.删除歌曲");
		System.out.println("4.歌曲插队");
		System.out.println("5.播放歌曲");
		//System.out.println("6.停止播放");
		System.out.println("7.退出");
		
		ArrayList lineUpList = new ArrayList();// 创建歌曲列表
		addMusicList(lineUpList);// 添加一部分歌曲至歌曲列表
		while (true) {
			System.out.print("请输入要执行的操作序号：");
			Scanner scan = new Scanner(System.in);
			int command = scan.nextInt();// //接收键盘输入的功能选项序号
			// 执行序号对应的功能
			switch (command) {
			case 0:// 添加歌曲至列表
				addMusic(lineUpList);
				break;
			case 1:// 将歌曲置顶
				setTop(lineUpList);
				break;
			case 2:// 将歌曲前移一位
				setBefore(lineUpList);
				break;
			case 3://删除歌曲
				deletemusic(lineUpList);
				break;
			case 4://特定位置插入歌曲
				insertmusic(lineUpList);
				break;
			case 5://特定位置插入歌曲
				playmusic(lineUpList);
				break;
			case 6://特定位置插入歌曲
				stopmusic(lineUpList);
				break;
			case 7:// 退出
				exit();
				break;
			default:
				System.out.println("----------------------------------");
				System.out.println("功能选择有误，请输入正确的功能序号!");
				break;
			}
			System.out.println("当前歌曲列表：" + lineUpList);
			System.out.println();
		}
	}
	//播放歌曲
	private static void playmusic(ArrayList lineUpList) {
		//System.out.println("额，暂时不会，所以说这是个不能放歌的KTV系统");
			playmusic sy;
			System.out.print("请输入要播放的歌曲名称：");
			String musicName = new Scanner(System.in).nextLine();// 获取键盘输入内容
			int a = lineUpList.indexOf(musicName);// 查找指定歌曲位置
			if(a < 0){
				System.out.println("当前列表中没有输入的歌曲！");
			}
			if(musicName.equals("Always Online")){
				sy=new playmusic("music/林俊杰 - Always Online.wav");   //音频的真正读取
				sy.start();
				System.out.print("输入0停止播放: ");
				Scanner in = new Scanner(System.in);// 获取输入的数字
				int number=in.nextInt();
				if(number==0){
					sy.stop();
				}
			}else if(musicName.equals("小酒窝")){	
				sy=new playmusic("music/林俊杰-小酒窝 (Live) .wav");   //音频的真正读取
				sy.start();
				System.out.print("输入0停止播放：");
				Scanner in = new Scanner(System.in);// 获取输入的数字
				int number=in.nextInt();
				if(number==0){
					sy.stop();
				}
			}else if(musicName.equals("童话镇")){	
				sy=new playmusic("music/陈一发儿 - 童话镇.wav");   //音频的真正读取
				sy.start();
				System.out.print("输入0停止播放：");
				Scanner in = new Scanner(System.in);// 获取输入的数字
				int number=in.nextInt();
				if(number==0){
					sy.stop();
				}
			}else if(musicName.equals("一笑倾城")){	
				sy=new playmusic("music/汪苏泷 - 一笑倾城.wav");   //音频的真正读取
				sy.start();
				System.out.print("输入0停止播放：");
				Scanner in = new Scanner(System.in);// 获取输入的数字
				int number=in.nextInt();
				if(number==0){
					sy.stop();
				}
			}else if(musicName.equals("有何不可")){	
				sy=new playmusic("music/许嵩 - 有何不可 (自白版).wav");   //音频的真正读取
				sy.start();
				System.out.print("输入0停止播放：");
				Scanner in = new Scanner(System.in);// 获取输入的数字
				int number=in.nextInt();
				if(number==0){
					sy.stop();
				}
			}
	}
	//停止播放
	private static void stopmusic(ArrayList lineUpList) {
		
	}
	//歌曲插队
	private static void insertmusic(ArrayList lineUpList) {
		System.out.print("请输入歌曲插队的位置：");
		Scanner in = new Scanner(System.in);// 获取输入的数字
		int number=in.nextInt();
		if(number<=0||number>lineUpList.size()){
			System.out.println("该位置因为某些原因暂无歌曲");
		}else{
			System.out.print("请输入要添加的歌曲名称：");
			String musicName = new Scanner(System.in).nextLine();// 获取键盘输入内容
			lineUpList.add(number-1, musicName);
			System.out.println("已经将歌曲"+"“"+ musicName+"”"+"添加到第"+number+"个位置");
		}
	}
	//删除歌曲
	private static void deletemusic(ArrayList lineUpList) {
		System.out.print("请输入要删除的歌曲名称：");
		String musicName = new Scanner(System.in).nextLine();// 获取键盘输入内容
		int position = lineUpList.indexOf(musicName);// 查找指定歌曲位置
		if(position<0){
			System.out.println("当前列表中没有需要删除的歌曲！");
		}else{
			lineUpList.remove(musicName);
			System.out.println("已将歌曲" +"“"+ musicName +"”"+ "删除");
		}
	}
	// 初始时添加歌曲名称
	private static void addMusicList(ArrayList lineUpList) {
		lineUpList.add("Always Online");
		lineUpList.add("小酒窝");
		lineUpList.add("童话镇");
		lineUpList.add("一笑倾城");
		lineUpList.add("有何不可");
		System.out.println();
		System.out.println("初始歌曲列表：" + lineUpList);
	}
	// 执行添加歌曲
	private static void addMusic(ArrayList lineUpList) {
		System.out.print("请输入要添加的歌曲名称：");
		String musicName = new Scanner(System.in).nextLine();// 获取键盘输入内容
		lineUpList.add(musicName);// 添加歌曲到列表的最后
		System.out.println("已添加歌曲：" + musicName);
	}
	// 执行将歌曲置顶
	private static void setTop(ArrayList lineUpList) {
		System.out.print("请输入要置顶的歌曲名称：");
		String musicName = new Scanner(System.in).nextLine();// 获取键盘输入内容
		int position = lineUpList.indexOf(musicName);// 查找指定歌曲位置
		if (position < 0) {// 判断输入歌曲是否存在
			System.out.println("当前列表中没有输入的歌曲！");
		} else {
			lineUpList.remove(musicName);// 移除指定的歌曲
			lineUpList.add(0, musicName);// 将指定的歌曲放到第一位
		}
		System.out.println("已将歌曲" +"”"+ musicName +"“"+ "置顶");
	}
	// 执行将歌曲置前一位
	private static void setBefore(ArrayList lineUpList) {
		System.out.print("请输入要置前的歌曲名称：");
		String musicName = new Scanner(System.in).nextLine();// 获取键盘输入内容
		int position = lineUpList.indexOf(musicName);// 查找指定歌曲位置
		if (position < 0) {// 判断输入歌曲是否存在
			System.out.println("当前列表中没有输入的歌曲！");
		} else if (position == 0) {// 判断歌曲是否已在第一位
			System.out.println("当前歌曲已在最顶部！");
		} else {
			lineUpList.remove(musicName);// 移除指定的歌曲
			lineUpList.add(position - 1, musicName);// 将指定的歌曲放到前一位
		}
		System.out.println("已将歌曲" + musicName + "置前一位");
	}
	// 退出
	private static void exit() {
		System.out.println("----------------退出---------------");
		System.out.println("您已退出系统");
		System.exit(0);
	}
}
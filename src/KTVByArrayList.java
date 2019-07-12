import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class KTVByArrayList{
	public static void main(String[] args) {
		System.out.println("-------------��ӭ�������ϵͳ------------");
		System.out.println("0.��Ӹ������б�");
		System.out.println("1.�������ö�");
		System.out.println("2.������ǰ��һλ");
		System.out.println("3.ɾ������");
		System.out.println("4.�������");
		System.out.println("5.���Ÿ���");
		//System.out.println("6.ֹͣ����");
		System.out.println("7.�˳�");
		
		ArrayList lineUpList = new ArrayList();// ���������б�
		addMusicList(lineUpList);// ���һ���ָ����������б�
		while (true) {
			System.out.print("������Ҫִ�еĲ�����ţ�");
			Scanner scan = new Scanner(System.in);
			int command = scan.nextInt();// //���ռ�������Ĺ���ѡ�����
			// ִ����Ŷ�Ӧ�Ĺ���
			switch (command) {
			case 0:// ��Ӹ������б�
				addMusic(lineUpList);
				break;
			case 1:// �������ö�
				setTop(lineUpList);
				break;
			case 2:// ������ǰ��һλ
				setBefore(lineUpList);
				break;
			case 3://ɾ������
				deletemusic(lineUpList);
				break;
			case 4://�ض�λ�ò������
				insertmusic(lineUpList);
				break;
			case 5://�ض�λ�ò������
				playmusic(lineUpList);
				break;
			case 6://�ض�λ�ò������
				stopmusic(lineUpList);
				break;
			case 7:// �˳�
				exit();
				break;
			default:
				System.out.println("----------------------------------");
				System.out.println("����ѡ��������������ȷ�Ĺ������!");
				break;
			}
			System.out.println("��ǰ�����б�" + lineUpList);
			System.out.println();
		}
	}
	//���Ÿ���
	private static void playmusic(ArrayList lineUpList) {
		//System.out.println("���ʱ���ᣬ����˵���Ǹ����ܷŸ��KTVϵͳ");
			playmusic sy;
			System.out.print("������Ҫ���ŵĸ������ƣ�");
			String musicName = new Scanner(System.in).nextLine();// ��ȡ������������
			int a = lineUpList.indexOf(musicName);// ����ָ������λ��
			if(a < 0){
				System.out.println("��ǰ�б���û������ĸ�����");
			}
			if(musicName.equals("Always Online")){
				sy=new playmusic("music/�ֿ��� - Always Online.wav");   //��Ƶ��������ȡ
				sy.start();
				System.out.print("����0ֹͣ����: ");
				Scanner in = new Scanner(System.in);// ��ȡ���������
				int number=in.nextInt();
				if(number==0){
					sy.stop();
				}
			}else if(musicName.equals("С����")){	
				sy=new playmusic("music/�ֿ���-С���� (Live) .wav");   //��Ƶ��������ȡ
				sy.start();
				System.out.print("����0ֹͣ���ţ�");
				Scanner in = new Scanner(System.in);// ��ȡ���������
				int number=in.nextInt();
				if(number==0){
					sy.stop();
				}
			}else if(musicName.equals("ͯ����")){	
				sy=new playmusic("music/��һ���� - ͯ����.wav");   //��Ƶ��������ȡ
				sy.start();
				System.out.print("����0ֹͣ���ţ�");
				Scanner in = new Scanner(System.in);// ��ȡ���������
				int number=in.nextInt();
				if(number==0){
					sy.stop();
				}
			}else if(musicName.equals("һЦ���")){	
				sy=new playmusic("music/������ - һЦ���.wav");   //��Ƶ��������ȡ
				sy.start();
				System.out.print("����0ֹͣ���ţ�");
				Scanner in = new Scanner(System.in);// ��ȡ���������
				int number=in.nextInt();
				if(number==0){
					sy.stop();
				}
			}else if(musicName.equals("�кβ���")){	
				sy=new playmusic("music/���� - �кβ��� (�԰װ�).wav");   //��Ƶ��������ȡ
				sy.start();
				System.out.print("����0ֹͣ���ţ�");
				Scanner in = new Scanner(System.in);// ��ȡ���������
				int number=in.nextInt();
				if(number==0){
					sy.stop();
				}
			}
	}
	//ֹͣ����
	private static void stopmusic(ArrayList lineUpList) {
		
	}
	//�������
	private static void insertmusic(ArrayList lineUpList) {
		System.out.print("�����������ӵ�λ�ã�");
		Scanner in = new Scanner(System.in);// ��ȡ���������
		int number=in.nextInt();
		if(number<=0||number>lineUpList.size()){
			System.out.println("��λ����ΪĳЩԭ�����޸���");
		}else{
			System.out.print("������Ҫ��ӵĸ������ƣ�");
			String musicName = new Scanner(System.in).nextLine();// ��ȡ������������
			lineUpList.add(number-1, musicName);
			System.out.println("�Ѿ�������"+"��"+ musicName+"��"+"��ӵ���"+number+"��λ��");
		}
	}
	//ɾ������
	private static void deletemusic(ArrayList lineUpList) {
		System.out.print("������Ҫɾ���ĸ������ƣ�");
		String musicName = new Scanner(System.in).nextLine();// ��ȡ������������
		int position = lineUpList.indexOf(musicName);// ����ָ������λ��
		if(position<0){
			System.out.println("��ǰ�б���û����Ҫɾ���ĸ�����");
		}else{
			lineUpList.remove(musicName);
			System.out.println("�ѽ�����" +"��"+ musicName +"��"+ "ɾ��");
		}
	}
	// ��ʼʱ��Ӹ�������
	private static void addMusicList(ArrayList lineUpList) {
		lineUpList.add("Always Online");
		lineUpList.add("С����");
		lineUpList.add("ͯ����");
		lineUpList.add("һЦ���");
		lineUpList.add("�кβ���");
		System.out.println();
		System.out.println("��ʼ�����б�" + lineUpList);
	}
	// ִ����Ӹ���
	private static void addMusic(ArrayList lineUpList) {
		System.out.print("������Ҫ��ӵĸ������ƣ�");
		String musicName = new Scanner(System.in).nextLine();// ��ȡ������������
		lineUpList.add(musicName);// ��Ӹ������б�����
		System.out.println("����Ӹ�����" + musicName);
	}
	// ִ�н������ö�
	private static void setTop(ArrayList lineUpList) {
		System.out.print("������Ҫ�ö��ĸ������ƣ�");
		String musicName = new Scanner(System.in).nextLine();// ��ȡ������������
		int position = lineUpList.indexOf(musicName);// ����ָ������λ��
		if (position < 0) {// �ж���������Ƿ����
			System.out.println("��ǰ�б���û������ĸ�����");
		} else {
			lineUpList.remove(musicName);// �Ƴ�ָ���ĸ���
			lineUpList.add(0, musicName);// ��ָ���ĸ����ŵ���һλ
		}
		System.out.println("�ѽ�����" +"��"+ musicName +"��"+ "�ö�");
	}
	// ִ�н�������ǰһλ
	private static void setBefore(ArrayList lineUpList) {
		System.out.print("������Ҫ��ǰ�ĸ������ƣ�");
		String musicName = new Scanner(System.in).nextLine();// ��ȡ������������
		int position = lineUpList.indexOf(musicName);// ����ָ������λ��
		if (position < 0) {// �ж���������Ƿ����
			System.out.println("��ǰ�б���û������ĸ�����");
		} else if (position == 0) {// �жϸ����Ƿ����ڵ�һλ
			System.out.println("��ǰ�������������");
		} else {
			lineUpList.remove(musicName);// �Ƴ�ָ���ĸ���
			lineUpList.add(position - 1, musicName);// ��ָ���ĸ����ŵ�ǰһλ
		}
		System.out.println("�ѽ�����" + musicName + "��ǰһλ");
	}
	// �˳�
	private static void exit() {
		System.out.println("----------------�˳�---------------");
		System.out.println("�����˳�ϵͳ");
		System.exit(0);
	}
}
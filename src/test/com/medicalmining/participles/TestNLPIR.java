package test.com.medicalmining.participles;

import org.junit.Test;

import kevin.zhang.NLPIR;

public class TestNLPIR {

	@Test
	public void testNLPIRDemo() throws Exception {
		NLPIR nlpir = new NLPIR();
		if (!NLPIR.NLPIR_Init("./file/".getBytes("utf-8"), 1)) {
			System.out.println("NLPIR��ʼ��ʧ��...");
			return;
		}
		String temp = "ÿ����ձ����ǵ�Ҫ����, ����Ͼ���������Ŀ�Ľ������.";
		byte[] resBytes = nlpir.NLPIR_ParagraphProcess(temp.getBytes("UTF-8"), 1);
		System.out.println("�ִʽ��: " + new String(resBytes, "UTF-8"));

		String utf8File = "./test/test-utf8.TXT";
		String utf8FileResult = "./test/test-utf8_result.TXT";
		nlpir.NLPIR_FileProcess(utf8File.getBytes("utf-8"), utf8FileResult.getBytes("utf-8"), 1);
		// �˳�, �ͷ���Դ
		NLPIR.NLPIR_Exit();
	}

	@Test
	public void testNLPIRAddWord() throws Exception {
		NLPIR nlpir = new NLPIR();
		if (!NLPIR.NLPIR_Init("./file/".getBytes("utf-8"), 1)) {
			System.out.println("NLPIR��ʼ��ʧ��...");
			return;
		}
		String temp = "���Է���Ϊ�׷�����Ҫ֢״������һ�����38�棬"
				+ "���ʳ����Ը��ȣ��ɰ���η����������ʹ���ؽ���ʹ��ͷʹ�������������ڣ�ʹ������ҩ����Ч;�����չ�ڣ�ͨ������������ҩ���Ƹ��ȡ�ʹ����Ƥ�ʼ��ؿɶ�������ɸ���";
		byte[] resBytes = nlpir.NLPIR_ParagraphProcess(temp.getBytes("UTF-8"), 1);
		System.out.println("�ִʽ��: " + new String(resBytes, "UTF-8"));
		nlpir.NLPIR_AddUserWord("��Ƥ�ʼ��� n".getBytes("utf-8"));
		byte[] resBytesAddWords = nlpir.NLPIR_ParagraphProcess(temp.getBytes("UTF-8"), 1);
		System.out.println("�ִʽ��: " + new String(resBytesAddWords, "UTF-8"));

	}

}

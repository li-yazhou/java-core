package org.alpha.javabase.javaprimer.javaprimer_code.chap28_Reflect_RegExp.src.cn.itcast.regex.demo;


/*
 * ������ʽ��
 * 
 * ������ʽ���ڲ����ַ������ݡ�
 * ͨ��һЩ�ض��ķ��������ֵġ�
 * ��������Ϊ������������ʽ������ҪѧϰһЩ���š�
 * 
 * ��Ȼ���ˣ������Ķ��Բ 
 *  
 * 
 * 
 */
public class RegexDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		String qq = "123k4567";
//		checkQQ(qq);
		
		String regex = "[1-9][0-9]{4,14}";//������ʽ��
		
//		boolean b = qq.matches(regex);		
//		System.out.println(qq+":"+b);
		
		
//		String str = "aoooooooob";
//		String reg = "ao{4,6}b";
//		boolean b = str.matches(reg);
//		System.out.println(str+":"+b);
		
		
	}
	
	/*
	 * ���󣺶���һ�����ܶ�QQ�Ž���У�顣
	 * Ҫ�󣺳���5~15. ֻ�������֣� 0���ܿ�ͷ
	 */
	public static void checkQQ(String qq){
		
		int len = qq.length();
		
		if(len>=5 && len<=15){
			
			if(!qq.startsWith("0")){
				try {
				long l = Long.parseLong(qq);
				
				System.out.println(l+":��ȷ");
				}catch(NumberFormatException e){
					System.out.println(qq+":���зǷ��ַ�");
				}
				
			}else{
				System.out.println(qq+":����0��ͷ");
			}
		}else{
			System.out.println(qq+":���ȴ���");
		}
		
		
		
	}

}

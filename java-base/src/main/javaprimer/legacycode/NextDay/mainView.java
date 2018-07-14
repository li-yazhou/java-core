
import java.util.Scanner;

public class mainView {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year = 0, month = 0, day = 0;
		MyDate mydate = null;
		int count = 0;
		while (true) {
			if (count != 0) {
				System.out.println();
				System.out.println("请输入选择，如果是Y，则继续测试，否则退出：");
				if (scanner.hasNext()) {
					String input = scanner.next();
					if (!"Y".equalsIgnoreCase(input)) {
						break;
					}
				}
			}
			count++;
			year = 0;
			month = 0 ;
			day = 0;
			/**
			 * 限制只能输入合法的日期
			 */

				System.out.print("****请输入年份：");
				if (scanner.hasNextInt()) {
					year = scanner.nextInt();
					System.out.print("****请输入月份：");
				}
				if (scanner.hasNextInt()) {
					month = scanner.nextInt();
					System.out.print("****请输入天数：");
				}
				if (scanner.hasNextInt()) {
					day = scanner.nextInt();
				}
				// if(year==0 || month== 0|| day==0){
				// break;
				// }
				System.out.print("****输入的日期为：");
				System.out.println(year + "-" + month + "-" + day);
				mydate = new MyDate(year, month, day);
				boolean isValidate = HandleDate.validateDate(mydate);
				if (!isValidate) {
					System.out.println("****输入的日期不存在！");
					continue;
				}
			System.out.print("****加一天之后的日期为：");
			mydate = HandleDate.addOneDay(mydate);
			System.out.println(mydate.getYear() + "-" + mydate.getMonth() + "-"
					+ mydate.getDay());
		}
		scanner.close();
	}
}

package adam$Drozdek$Java$ds;

import java.util.*;

public class SimpleFraction {
	public static void main(String[] args) {
		new Fraction();

	}

}

// 1.编写一个Fraction类，定义分数的加减乘除。然后编写一个分数的化简方法以及分数的输入输出方法。
class Fraction {
	{
		System.out.println("请选择操作\n1.分数相加\n2.分数相减\n3.分数相乘\n4.分数相除\n5.化简分数");
		System.out.println("请输入两个分数，格式为想x/y，p/q：");
		try (Scanner in = new Scanner(System.in);) {
			String string = in.nextLine();
			String str = in.nextLine();
			if ((string.matches("[1-4]") && str
					.matches("-?[0-9]+(/-?[1-9][0-9]*)?,-?[1-9][0-9]*(/-?[1-9][0-9]*)?"))
					|| (string.matches("5") && str
							.matches("-?[0-9]+(/-?[1-9][0-9]*)?"))) {
				int cho = Integer.valueOf(string);

				String[] s = new String[2];
				if (str.contains(",")) {
					s = str.split(",");
				} else {
					s[0] = str;
					s[1] = "";
				}

				if (s[0].matches("-?[0-9]+(/-?[1-9][0-9]*)?")
						&& s[1].matches("-?[1-9][0-9]*(-?/[1-9][0-9]*)?")) {
					choose(cho, s[0], s[1]);
				} else if (s[0].matches("-?[0-9]+(/-?[1-9][0-9]*)?")
						&& s[1].equals("")) {
					choose(5, s[0], "");
				} else {
					System.out.println("error enter");
					new Fraction();
				}
			} else {
				System.out.println("error enter");
				new Fraction();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void choose(int cho, String s1, String s2) {
		long a = 0, b = 0, c = 0, d = 0;
		if (s2.length() > 0) {
			if (s1.contains("/")) {
				String[] s = s1.split("/");
				a = Long.valueOf(s[0]);
				b = Long.valueOf(s[1]);
			} else {
				a = Long.valueOf(s1);
				b = 1;
			}
			if (s2.contains("/")) {
				String[] s = s2.split("/");
				c = Long.valueOf(s[0]);
				d = Long.valueOf(s[1]);
			} else {
				c = Long.valueOf(s2);
				d = 1;
			}
		}
		switch (cho) {
		case 1:
			System.out.println(add(a, b, c, d));
			break;
		case 2:
			System.out.println(minus(a, b, c, d));
			break;
		case 3:
			System.out.println(multiply(a, b, c, d));
			break;
		case 4:
			System.out.println(divide(a, b, c, d));
			break;
		case 5:
			System.out.println(simple(s1));
			break;
		default:
			System.out.println("error enter");
			new Fraction();
		}
	}

	private String simple(String s1) {
		long a, b;
		String sing = "";
		if (s1.contains("/")) {
			String[] s = s1.split("/");
			a = Math.abs(Long.valueOf(s[0]));
			b = Math.abs(Long.valueOf(s[1]));
			if (s[0].contains("-") ^ s[1].contains("-")) {
				sing = "-";
			}
		} else {
			a = Math.abs(Long.valueOf(s1));
			b = 1;
			if (s1.contains("-")) {
				sing = "-";
			}
		}
		long c = a <= b ? a : b;
		if (c == 0) {
			s1 = String.valueOf(a + "/" + b);
		}
		for (long i = 1; i <= c;) {
			if (a % i == 0 && b % i == 0 && i != 1) {
				a /= i;
				b /= i;
				System.out.println("a=" + a + "  b=" + b);
			} else {
				i++;
				// System.out.println("i=" + i);
			}
		}
		if (a == 0) {
			s1 = "0";
		} else {
			if (b == 1) {
				s1 = String.valueOf(a);
			} else {
				s1 = String.valueOf(a + "/" + b);
			}
		}
		return sing + s1;
	}

	String divide(long a, long b, long c, long d) {
		return simple((a * d) + "/" + (b * c));
	}

	String multiply(long a, long b, long c, long d) {
		return simple((a * c) + "/" + (b * d));
	}

	String minus(long a, long b, long c, long d) {
		return simple((a * d - b * c) + "/" + (b * d));
	}

	String add(long a, long b, long c, long d) {
		return simple((a * d + b * c) + "/" + (b * d));
	}

}

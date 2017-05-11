package com.suanming.bazi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ������Ԫ������ʱ����ȡĳ���˵��������֣��Լ�ũ������
 */
public class BaZi {
	private int year;
	private int month;
	private int day;
	private int luhour;
	private boolean leap;
	Date baseDate = null;

	final static String chineseNumber[] = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "ʮ", "ʮһ", "��" };
	final static String[] Gan = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��" };
	final static String[] Zhi = { "��", "��", "��", "î", "��", "��", "��", "δ", "��", "��", "��", "��" };
	static SimpleDateFormat chineseDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	final static long[] lunarInfo = new long[] { 0x04bd8, 0x04ae0, 0x0a570, 0x054d5, 0x0d260, 0x0d950, 0x16554, 0x056a0,
			0x09ad0, 0x055d2, 0x04ae0, 0x0a5b6, 0x0a4d0, 0x0d250, 0x1d255, 0x0b540, 0x0d6a0, 0x0ada2, 0x095b0, 0x14977,
			0x04970, 0x0a4b0, 0x0b4b5, 0x06a50, 0x06d40, 0x1ab54, 0x02b60, 0x09570, 0x052f2, 0x04970, 0x06566, 0x0d4a0,
			0x0ea50, 0x06e95, 0x05ad0, 0x02b60, 0x186e3, 0x092e0, 0x1c8d7, 0x0c950, 0x0d4a0, 0x1d8a6, 0x0b550, 0x056a0,
			0x1a5b4, 0x025d0, 0x092d0, 0x0d2b2, 0x0a950, 0x0b557, 0x06ca0, 0x0b550, 0x15355, 0x04da0, 0x0a5d0, 0x14573,
			0x052d0, 0x0a9a8, 0x0e950, 0x06aa0, 0x0aea6, 0x0ab50, 0x04b60, 0x0aae4, 0x0a570, 0x05260, 0x0f263, 0x0d950,
			0x05b57, 0x056a0, 0x096d0, 0x04dd5, 0x04ad0, 0x0a4d0, 0x0d4d4, 0x0d250, 0x0d558, 0x0b540, 0x0b5a0, 0x195a6,
			0x095b0, 0x049b0, 0x0a974, 0x0a4b0, 0x0b27a, 0x06a50, 0x06d40, 0x0af46, 0x0ab60, 0x09570, 0x04af5, 0x04970,
			0x064b0, 0x074a3, 0x0ea50, 0x06b58, 0x055c0, 0x0ab60, 0x096d5, 0x092e0, 0x0c960, 0x0d954, 0x0d4a0, 0x0da50,
			0x07552, 0x056a0, 0x0abb7, 0x025d0, 0x092d0, 0x0cab5, 0x0a950, 0x0b4a0, 0x0baa4, 0x0ad50, 0x055d9, 0x04ba0,
			0x0a5b0, 0x15176, 0x052b0, 0x0a930, 0x07954, 0x06aa0, 0x0ad50, 0x05b52, 0x04b60, 0x0a6e6, 0x0a4e0, 0x0d260,
			0x0ea65, 0x0d530, 0x05aa0, 0x076a3, 0x096d0, 0x04bd7, 0x04ad0, 0x0a4d0, 0x1d0b6, 0x0d250, 0x0d520, 0x0dd45,
			0x0b5a0, 0x056d0, 0x055b2, 0x049b0, 0x0a577, 0x0a4b0, 0x0aa50, 0x1b255, 0x06d20, 0x0ada0 };

	final static int yy[] = { 12, 9, 6, 7, 12, 5, 9, 8, 7, 8, 15, 9, 16, 8, 8, 19, 12, 6, 8, 7, 5, 15, 6, 16, 15, 7, 9,
			12, 10, 7, 15, 6, 5, 14, 14, 9, 7, 7, 9, 12, 8, 7, 13, 5, 14, 5, 9, 17, 5, 7, 12, 8, 8, 6, 19, 6, 8, 16, 10,
			6 };
	final static int mm[] = { 6, 7, 18, 9, 5, 16, 9, 15, 18, 8, 9, 5 };
	final static int dd[] = { 5, 10, 8, 15, 16, 15, 8, 16, 8, 16, 19, 17, 8, 17, 10, 8, 9, 18, 5, 15, 10, 9, 8, 9, 15,
			18, 7, 8, 16, 6 };
	final static int hh[] = { 16, 6, 7, 10, 9, 16, 10, 8, 8, 9, 6, 6 };

	/**
	 * ��ʮ����
	 */
	public static final String[] jiazhi = { "����", "�ҳ�", "����", "��î", "�쳽", "����", "����", "��δ", "����", "����", "����", "�Һ�",
			"����", "����", "����", "��î", "����", "����", "����", "��δ", "����", "����", "����", "����", "����", "����", "����", "��î", "�ɳ�", "����",
			"����", "��δ", "����", "����", "����", "����", "����", "����", "����", "��î", "�׳�", "����", "����", "��δ", "����", "����", "����", "����",
			"����", "���", "����", "��î", "����", "����", "����", "��δ", "����", "����", "����", "�ﺥ" };

	private Calendar cal;

	/**
	 * @param hour
	 *            �����ʱ�䷶Χ��1-12�����弸�㵽��������ʱ����ʱ��ο�����ĵ� �����ѡ������ "�ӣ�1", "��2", "����3",
	 *            "î��4", "����5", "�ȣ�6", "�磺7", "δ��8", "�꣺9", "�ϣ�10", "�磺11",
	 *            "����12"
	 * @author kongqz
	 */
	public String getYearGanZhi() {
		// 1864���Ǽ����꣬ÿ����ʮ��һ������
		int idx = (year - 1864) % 60;
		// û�й����ڵĻ���ô�껹����һ��ģ��˴������ݵĸ�֧
		String y = jiazhi[idx];

		String m = "";
		String d = "";
		String h = "";
		idx = idx % 5;
		int idxm = 0;
		/**
		 * �������� �׼�֮������ף��Ҹ�֮����Ϊͷ�� �����ض�Ѱ���𣬶�����λ˳������ �������η��٣�����֮�Ϻ�׷��
		 */
		idxm = (idx + 1) * 2;
		if (idxm == 10)
			idxm = 0;
		// ����·ݵĸ�֧
		m = Gan[(idxm + month - 1) % 10] + Zhi[(month + 2 - 1) % 12];

		/*
		 * �����1900��1��31�ռ׳����������� �׳����ǵ���ʮ��
		 */
		int offset = (int) ((cal.getTime().getTime() - baseDate.getTime()) / 86400000L);
		offset = (offset + 40) % 60;
		// ����յĸ�֧
		d = jiazhi[offset];

		/**
		 * ������ʱ �׼������ף��Ҹ��������� ���������𣬶��ɸ��Ӿӣ� ���η�������������;��
		 */

		offset = (offset % 5) * 2;
		// ���ʱ���ĸ�֧
		h = Gan[(offset + luhour - 1) % 10] + Zhi[luhour - 1];
		// �ڴ˴�������ǵ�������ʱ����ɵ�֧
		return y + m + d + h;
	}

	public String getShichenFromDay(int offset) {

		return null;
	}

	// ====== ����ũ�� y���������
	final private static int yearDays(int y) {
		int i, sum = 348;
		for (i = 0x8000; i > 0x8; i >>= 1) {
			if ((lunarInfo[y - 1900] & i) != 0) {
				sum += 1;
			}
		}
		return (sum + leapDays(y));
	}

	// ====== ����ũ�� y�����µ�����
	final private static int leapDays(int y) {
		if (leapMonth(y) != 0) {
			if ((lunarInfo[y - 1900] & 0x10000) != 0) {
				return 30;
			} else {
				return 29;
			}
		} else {
			return 0;
		}
	}

	// ====== ����ũ�� y�����ĸ��� 1-12 , û�򴫻� 0
	final private static int leapMonth(int y) {
		return (int) (lunarInfo[y - 1900] & 0xf);
	}

	// ====== ����ũ�� y��m�µ�������
	final private static int monthDays(int y, int m) {
		if ((lunarInfo[y - 1900] & (0x10000 >> m)) == 0) {
			return 29;
		} else {
			return 30;
		}
	}

	/***
	 * @return ����ũ�� y�����Ф
	 */
	final public String animalsYear() {
		final String[] Animals = new String[] { "��", "ţ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��" };
		return Animals[(year - 4) % 12];
	}

	// ====== ���� ���յ�offset ���ظ�֧, 0=����
	final private static String cyclicalm(int num) {
		return (Gan[num % 10] + Zhi[num % 12]);
	}

	// ====== ���� offset ���ظ�֧, 0=����
	final public String cyclical() {
		int num = year - 1900 + 36;
		return (cyclicalm(num));
	}

	/**
	 * ����y��m��d�ն�Ӧ��ũ��. yearCyl3:ũ������1864������� ? monCyl4:��1900��1��31������,������
	 * dayCyl5:��1900��1��31����������,�ټ�40 ?
	 *
	 * @param cal
	 * @return
	 */
	public BaZi(Calendar cal, int mhour) {
		this.cal = cal;
		int yearCyl, monCyl, dayCyl;
		int leapMonth = 0;

		try {
			baseDate = chineseDateFormat.parse("1900-1-31");
		} catch (ParseException e) {
			e.printStackTrace(); // To change body of catch statement use
									// Options | File Templates.
		}
		// �����1900��1��31����������
		int offset = (int) ((cal.getTime().getTime() - baseDate.getTime()) / 86400000L);
		dayCyl = offset + 40;
		monCyl = 14;
		// ��offset��ȥÿũ���������
		// ���㵱����ũ���ڼ���
		// i���ս����ũ�������
		// offset�ǵ���ĵڼ���
		int iYear, daysOfYear = 0;
		for (iYear = 1900; iYear < 2050 && offset > 0; iYear++) {
			daysOfYear = yearDays(iYear);
			offset -= daysOfYear;
			monCyl += 12;
		}
		if (offset < 0) {
			offset += daysOfYear;
			iYear--;
			monCyl -= 12;
		}
		// ũ�����
		year = iYear;
		yearCyl = iYear - 1864;
		leapMonth = leapMonth(iYear); // ���ĸ���,1-12
		leap = false;
		// �õ��������offset,�����ȥÿ�£�ũ��������������������Ǳ��µĵڼ���
		int iMonth, daysOfMonth = 0;
		for (iMonth = 1; iMonth < 13 && offset > 0; iMonth++) {
			// ����
			if (leapMonth > 0 && iMonth == (leapMonth + 1) && !leap) {
				--iMonth;
				leap = true;
				daysOfMonth = leapDays(year);
			} else {
				daysOfMonth = monthDays(year, iMonth);
			}
			offset -= daysOfMonth;
			// �������
			if (leap && iMonth == (leapMonth + 1)) {
				leap = false;
			}
			if (!leap) {
				monCyl++;
			}
		}
		// offsetΪ0ʱ�����Ҹղż�����·������£�ҪУ��
		if (offset == 0 && leapMonth > 0 && iMonth == leapMonth + 1) {
			if (leap) {
				leap = false;
			} else {
				leap = true;
				--iMonth;
				--monCyl;
			}
		}
		// offsetС��0ʱ��ҲҪУ��
		if (offset < 0) {
			offset += daysOfMonth;
			--iMonth;
			--monCyl;
		}
		month = iMonth;
		day = offset + 1;
		if (mhour % 2 == 0) {
			luhour = (mhour + 2) / 2;
		} else {
			if (mhour == 23) {
				luhour = 1;
			} else {
				luhour = (mhour + 3) / 2+1;
			}
		}
		System.out.println(year + "/" + month + "/" + day + "/" + luhour);
	}

	public static String getChinaDayString(int day) {
		String chineseTen[] = { "��", "ʮ", "إ", "ئ" };
		int n = day % 10 == 0 ? 9 : day % 10 - 1;
		if (day > 30) {
			return "";
		}
		if (day == 10) {
			return "��ʮ";
		} else {
			return chineseTen[day / 10] + chineseNumber[n];
		}
	}

	public String toString() {
		return getYearStr(year) + "��" + (leap ? "��" : "") + chineseNumber[month - 1] + "��" + getChinaDayString(day);
	}

	public String toZong() {
		int n = yy[(year - 1864) % 60] + mm[month - 1] + dd[day - 1] + hh[luhour-1];
		return n / 10 + "��" + n % 10 + "Ǯ";
	}
	
	public int toZongLiang() {
		int n = yy[(year - 1864) % 60] + mm[month - 1] + dd[day - 1] + hh[luhour-1];
		return n;
	}

	public String getYearStr(int year) {
		String[] chineseword = { "��", "һ", "��", "��", "��", "��", "��", "��", "��", "��" };
		String ys = "";
		int index = year / 1000;
		ys += chineseword[index];
		year = year % 1000;
		index = year / 100;
		ys += chineseword[index];
		year = year % 100;
		index = year / 10;
		ys += chineseword[index];
		year = year % 10;
		index = year;
		ys += chineseword[index];
		return ys;
	}

	public static String getSixtyDay() {
		String temp = "";
		for (int i = 0; i < 60; i++) {
			temp += ",/" + cyclicalm(i) + "/";
		}
		return temp;
	}

//	/**
//	 * ���һ������Ԫ 1983-01-10 ����12��30�����˵ļ��㡣 ����12������й��ĹŴ�������������ʱ
//	 * ��ʱ23.00��1.00,��ʱ1.00��3.00,��ʱ3.00��5.00,îʱ5.00��7.00,
//	 * ��ʱ7.00��9.00,��ʱ9.00��11.00,��ʱ11.00��13.00,δʱ13.00��15.00
//	 * ��ʱ15.00��17.00,��ʱ17.00��19.00,��ʱ19.00��21.00,��ʱ21.00��23.00
//	 */
//	public static void main(String[] args) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Calendar cal = Calendar.getInstance();
//		try {
//			// �趨���˵���Ԫʱ��Ϊ1983-01-10
//			cal.setTime(sdf.parse("1989-11-23"));
//			BaZi lunar = new BaZi(cal, 10);
//			System.out.println("����ũ�������ڡ�" + lunar.toString() + "��");
//			// �˴���Ϊ�˻�ȡʱ�����й��İ���ѧ˵�ϵ���ʾ����������ʱ����
//			System.out.println("���˰��֡�" + lunar.getYearGanZhi() + "��");
//			// ��ȡ��Ф
//			System.out.println("���˵�ũ����Ф��" + lunar.animalsYear() + "��");
//			// ����
//			System.out.println("���˵Ĺ��ء�" + lunar.toZong() + "��");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}

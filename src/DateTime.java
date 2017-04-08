public class DateTime {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int minutes;
	private long miliSeconds;

	public long getMiliSeconds() {
		return miliSeconds = System.currentTimeMillis();

	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDate() {
		return day;
	}

	public int getHour() {
		this.hour = (int) ((getMiliSeconds() / (1000 * 60 * 60)) % 24);
		return hour;

	}

	public int getMinutes() {
		this.minutes = (int) ((getMiliSeconds() / (1000 * 60)) % 60);
		return minutes;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public boolean valDate(String date) throws NumberFormatException {
		if (Integer.parseInt(date.substring(0, 1)) < 0 || Integer.parseInt(date.substring(0, 1)) > 31
				|| Integer.parseInt(date.substring(3, 4)) > 12 || Integer.parseInt(date.substring(3, 4)) < 0) {
			System.out.println("Please enter valide Date!");
			return true;
		}else if(Integer.parseInt(date.substring(6, 9))<200||Integer.parseInt(date.substring(3, 4))>3000){
			System.out.println("Please enter valid Year!");
			return true;
		}else{
			return false;
		}
	}

	public void setHour(int hour) {
		this.hour = hour;

	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public String getHHMM() {
		return getHour() + ":" + getMinutes();
	}

	public long calculateDifference(long preTime) {
		return getMiliSeconds() - preTime;
	}
}

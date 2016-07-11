public class CountSundays {

	public static void main(String[] args) {
		
		//ASSUMPTIONS:
		// { Sunday = 0, Monday = 1, Tuesday = 2... Saturday = 6 }
				
		int currentYear = 1901;
		int yearLimit = 2001;
		int firstDayOfMonth = 2; //January 1, 1901 was a Tuesday, hence 2
		int countOfFirstSundays = 0;
		
		if (firstDayOfMonth == 0) countOfFirstSundays++;
		for(int yr = currentYear; yr < yearLimit; yr++) {
			int numOfDaysInMonth = 0;
			for(int mm = 1; mm <= 12; mm++) {
				// 30 days for April, June, September and November
				if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
					numOfDaysInMonth = 30;
				}
				//28, 02 29 days for February based on leap year
				else if (mm==2) {
					if(isLeap(yr)) {
						numOfDaysInMonth = 29;
					} else {
						numOfDaysInMonth = 28;
					}
				}
				//31 days for all other months
				else {
					numOfDaysInMonth = 31;
				}
				firstDayOfMonth = (firstDayOfMonth + numOfDaysInMonth) % 7;
				if(firstDayOfMonth == 0) {
					countOfFirstSundays++;
				}
			}
		}
		
		System.out.println(countOfFirstSundays);
		
	}

	private static boolean isLeap(int yr) {
		if(yr % 400 == 0) return true;
		
		if(yr % 100 != 0 && yr % 4 == 0) return true;
		
		return false;
	}

}

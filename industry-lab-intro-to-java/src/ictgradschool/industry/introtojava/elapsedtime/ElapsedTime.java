package ictgradschool.industry.introtojava.elapsedtime;

/**
 * Programming for Industry - Lab 01
 * Exercise Five - Calculate Elapsed Time
 * 
 * Note: Put your answers in between the "// Answer here //" comments. Do not modify other parts of the class.
 */
public class ElapsedTime {

	/**
	 * Calculate elapsed time.
	 */
	public void getTimeElapsed(int firstHour, int firstMinutes, int secondHour, int secondMinutes) {
		int maxTimeDiffInMinutes = 12 * 60; // 12 hours => 720 minutes
		int allMinutes = 0;
		// Answer here
		int hour_pass = secondHour - firstHour;
		int minute_pass = secondMinutes - firstMinutes;
		allMinutes = hour_pass * 60 + minute_pass;

		Math.max(allMinutes,maxTimeDiffInMinutes);
		if (allMinutes > maxTimeDiffInMinutes)
		{
			System.out.println("It is out of the max time difference.");
		}
		else if (allMinutes < 0)
		{
			allMinutes = allMinutes + 12 * 60;
			System.out.println(allMinutes / 60 + " hours and " + allMinutes % 60 + " minutes have passed.");
		}
		else
		//
		System.out.println(allMinutes / 60 + " hours and " + allMinutes % 60 + " minutes have passed.");
	}


	/**
	 * Don't edit this - but read/use this for testing if you like.
	 */
	public static void main(String[] args) {
		ElapsedTime cr = new ElapsedTime();

		cr.getTimeElapsed(5, 30, 4, 45); // 11 hours and 15 minutes have passed.
		cr.getTimeElapsed(3, 30, 7, 15); // 3 hours and 45 minutes have passed.
		cr.getTimeElapsed(0, 0, 12, 0); // 12 hours and 0 minutes have passed.
		cr.getTimeElapsed(8, 0, 8, 0); // 0 hours and 0 minutes have passed.
		cr.getTimeElapsed(5, 30, 5, 29); // 11 hours and 59 minutes have passed.
	}

}

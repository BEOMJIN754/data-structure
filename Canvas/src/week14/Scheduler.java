package week14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Scheduler {
	class Schedule implements Comparable<Schedule> {
		int time;
		String task;
		public Schedule(int t, String str) {
			time = t;
			task = str;
		}
		@Override
		public boolean equals(Object that) {
			//return (time==((Schedule)that).time)&&(task.equals(((Schedule)that).task));
			return time == ((Schedule) that).time;
		}
		@Override
		public int compareTo(Schedule that) {
			if ((time>((Schedule)that).time))
				return 1;
			else if ((time<((Schedule)that).time))
				return -1;
			else return 0;
		}
		public String toString() {
			return ""+time + ":00 " + task+" ";
		}
	}

	ArrayList<LinkedList<Schedule>> schedule;

	public Scheduler() {
		schedule = new ArrayList<>();
		for (int i = 0; i <= 31; i++) {
			schedule.add(new LinkedList<>());
		}
	}

	public void addNSort(int d, int t, String tk) {
		if (d < 1 || d > 31 || t < 0 || t > 23) return;
		LinkedList<Schedule> day = schedule.get(d);
		day.add(new Schedule(t, tk));
		Collections.sort(day);
	}
	public void finish(int d, int t) {
		if (d < 1 || d > 31) return;
		schedule.get(d).remove(new Schedule(t, ""));
	}

	public void monthPlan() {
		System.out.println("\n<Monthly Schedule>");
		for (int d = 1; d <= 31; d++) {
			LinkedList<Schedule> day = schedule.get(d);
			if (!day.isEmpty()) {
				System.out.print("Day "+d +" => {");

				for (Schedule s : day) {
					System.out.print(  s+ " ");
				}
				System.out.print("}");
				System.out.println();
			}
		}
	}

	public void dayPlan(int date) {
		LinkedList<Schedule> day = schedule.get(date);
		if (day.isEmpty()) {
			System.out.println(date + " No Schedule");
		} else {
			System.out.print("Day " + date + " => {");
			for (Schedule s : day) {
				System.out.print(s + "  ");
			}
			System.out.print("}");
			System.out.println();
		}
	}

	public void findAll(String t) {
		int count = 0;
		for (int d = 1; d <= 31; d++) {
			for (Schedule s : schedule.get(d)) {
				if (s.task.equals(t)) {
					count++;
				}
			}
		}
		System.out.printf("Search Result : %s => %d schedule(s) found!%n", t, count);
		if (count > 0) {
			for (int d = 1; d <= 31; d++) {
				for (Schedule s : schedule.get(d)) {
					if (s.task.equals(t)) {
						System.out.printf("Day %d %02d:00 %s%n", d, s.time, s.task);
					}

				}
			}
			System.out.println();
		}
	}



	public static void main(String[] args) {
		Object[][] input = {
				{1, 6, "jogging"},{12, 8, "beakfast-meeting"},{1, 9, "biz-meeting"}, // date, time, task
				{1, 12, "lunch"},{12, 14, "hospital"},{23, 18, "tennis"},{11, 21, "movie"},
				{3, 12, "lunch"},{22, 16, "hospital"},{7, 18, "tennis"},{17, 9, "movie"},
				{3, 6, "jogging"},{22, 8, "beakfast-meeting"},{7, 9, "biz-meeting"}
		};
		Scheduler sch = new Scheduler();
		for (int i=0;i<input.length;i++){
			sch.addNSort((int)input[i][0],(int)input[i][1],(String)input[i][2]);
		}
		sch.monthPlan();

		System.out.println("\n>> After add a few more tasks...");
		sch.addNSort(17, 8, "jogging");
		sch.addNSort(12, 7, "tennis");
		sch.addNSort(12, 25, "tennis"); //worng input => must be ignored!
		sch.addNSort(32, 2, "tennis"); // worng input => must be ignored!
		sch.monthPlan();

		System.out.println("\n<Day Plan>");
		sch.dayPlan(3);
		sch.dayPlan(22);

		System.out.println("\n<Search Task>");
		sch.findAll("tennis");
		sch.findAll("hospital");
		sch.findAll("Study");

		System.out.println("\n>> After finish a few tasks...");
		sch.finish(1, 6);
		sch.finish(23, 18);
		sch.finish(22, 16);
		sch.finish(22, 17);
		sch.monthPlan();
	}
}

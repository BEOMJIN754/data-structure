package week10;

public class MyScheduler {
    public static class Task implements Comparable<Task> {
        int time;
        String task;

        public Task(int tm, String tk) {
            time = tm;
            task = tk;
        }

        @Override
        public boolean equals(Object that) {
            if (!(that instanceof Task)) return false;
            Task t = (Task) that;
            return this.time == t.time && this.task.equals(t.task);
        }

        @Override
        public String toString() {
            return time + ":00 " + task;
        }

        @Override
        public int compareTo(Task that) {
            return Integer.compare(this.time, that.time);
        }
    }

    MyLinkedList2<Task> list;

    public MyScheduler() {
        list = new MyLinkedList2<>();
    }

    public void register(Task p) {
        int i = 0;
        while (i < list.size() && list.get(i).compareTo(p) < 0) {
            i++;
        }
        list.add(i, p); // insert in order
    }

    public void done(Task p) {
        list.remove(p);
    }

    public void showSchedule() {
        list.showList();
    }
	
	public static void main(String[] args) {
		MyScheduler ms = new MyScheduler();
		
		ms.showSchedule();
		
		ms.register(new Task(10, "Seminar"));
		ms.register(new Task(19, "Party"));
		ms.register(new Task(7, "Swimming"));
		ms.showSchedule();
		
		ms.register(new Task(9, "Tea Meeting"));
		ms.register(new Task(13, "Lunch"));
		ms.done(new Task(7, "Swimming"));
		ms.showSchedule();
		
		ms.done(new Task(9, "Tea Meeting"));
		ms.register(new Task(17, "Tennis"));
		ms.showSchedule();
		
		ms.done(new Task(9, "Seminar"));
		ms.showSchedule();
		ms.done(new Task(10, "Seminar"));
		ms.showSchedule();

	}

}

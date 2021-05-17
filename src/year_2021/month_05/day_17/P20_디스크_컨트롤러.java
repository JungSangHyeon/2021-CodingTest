package year_2021.month_05.day_17;

import java.util.ArrayList; 
import java.util.Arrays;
import java.util.Collections;

public class P20_��ũ_��Ʈ�ѷ� {

	/**
	 * �ز� �������
	 * �ٸ� ��� Ǯ�̸� �� �����غ���. 
	 * ���� �� ���� ���ݾ�.
	 * ȿ���� �׽�Ʈ �־����� ������ Ż���ϰ�? �Ƹ�?
	 */
	public static void main(String[] args) {
		System.out.println(solution3(new int[][] {{0,3}, {1,9}, {2,6}}));
		System.out.println(solution3(new int[][] {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}}));
	}
	
	public static int solution3(int[][] jobs) {
		ArrayList<Job> jobs2 = new ArrayList<>();
		for(int[] job : jobs) {jobs2.add(new Job(job[0], job[1]));}
		
		int sum = 0, time = 0;
		Job lastJob = getLastJob(time, jobs2);
		boolean isWorking = lastJob!=null;
		while(jobs2.size()!=0) {
			if(isWorking && time-lastJob.startTime == lastJob.needTime) {
				jobs2.remove(lastJob);
				isWorking = false;	
				sum+=(time-lastJob.requestTime);
			}
			if(!isWorking) {
				lastJob = getLastJob(time, jobs2);
				if(lastJob!=null) isWorking=true;
			}
			time++;
		}
        return sum/jobs.length;
    }
	public static Job getLastJob(int time, ArrayList<Job> jobs2) {
		final int finalTime = time;
		Job[] executables = jobs2.stream().filter(j->(j.requestTime<=finalTime)).toArray(Job[]::new);
		Arrays.sort(executables,(Job j1, Job j2) -> {return Math.max(j1.requestTime-finalTime,0)+j1.needTime >= Math.max(j2.requestTime-finalTime, 0)+j2.needTime? 1:-1;} );
		if(executables.length!=0) {
			Job lastJob = executables[0];
			lastJob.startTime = time;
			return lastJob;
		}
		return null;
	}
	private static class Job {
		public int requestTime, needTime, startTime, endTime;
		public Job(int requestTime, int needTime) {this.requestTime=requestTime; this.needTime=needTime;}
	}
	
	public static double solution2(int[][] jobs) {
		ArrayList<Job> jobs2 = new ArrayList<>();
		for(int[] job : jobs) {jobs2.add(new Job(job[0], job[1]));}
		
		int sum = 0, time = 0;
		boolean isWorking = false;
		Job lastJob = null;
		while(jobs2.size()!=0) {
			System.out.println(time+"�� ����");
			if(!isWorking) {
				System.out.println("���� ������ ã���ϴ�.");
				final int finalTime = time;
				Job[] executables = jobs2.stream().filter(j->(j.requestTime<=finalTime)).toArray(Job[]::new);
				Arrays.sort(executables,
						(Job j1, Job j2) -> {return Math.max(j1.requestTime-finalTime,0)+j1.needTime >= Math.max(j2.requestTime-finalTime, 0)+j2.needTime? 1:-1;} 
				);
				if(executables.length!=0) {
					lastJob = executables[0];
					lastJob.startTime = time;
					isWorking = true;
					System.out.println("ã�� ��: "+lastJob.requestTime+", "+lastJob.needTime);
				}else {
					System.out.println("���� ������ ���� �����ϴ�.");
				}
			}else {
				System.out.println("���� ���� ��: "+lastJob.requestTime+", "+lastJob.needTime);
				System.out.println("���� : "+(time-lastJob.startTime)+" / "+lastJob.needTime);
			}
			if(time-lastJob.startTime == lastJob.needTime) {
				jobs2.remove(lastJob);
				isWorking = false;	
				sum+=(time-lastJob.requestTime);
				System.out.println("���� ����. ��û~�������: "+(time-lastJob.requestTime));
			}
			
			if(!isWorking) {
				System.out.println("���� ������ ã���ϴ�.");
				final int finalTime = time;
				Job[] executables = jobs2.stream().filter(j->(j.requestTime<=finalTime)).toArray(Job[]::new);
				Arrays.sort(executables,
						(Job j1, Job j2) -> {return Math.max(j1.requestTime-finalTime,0)+j1.needTime >= Math.max(j2.requestTime-finalTime, 0)+j2.needTime? 1:-1;} 
				);
				if(executables.length!=0) {
					lastJob = executables[0];
					lastJob.startTime = time;
					isWorking = true;
					System.out.println("ã�� ��: "+lastJob.requestTime+", "+lastJob.needTime);
				}else {
					System.out.println("���� ������ ���� �����ϴ�.");
				}
			}
			time++;
			System.out.println(); 
		}
        return sum/jobs.length;
    }
	
	// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	
	public static double solution(int[][] jobs) {
		double sum = 0;
		ArrayList<Job> jobs2 = new ArrayList<>();
		for(int[] job : jobs) {jobs2.add(new Job(job[0], job[1]));}
		
		Job lastJob = null;
		for(int i=0; i<jobs.length; i++) {
			final int tempTime = (lastJob==null)? 0:lastJob.endTime;
			Collections.sort(jobs2, (Job j1, Job j2) -> Math.max(j1.requestTime-tempTime, 0)+j1.needTime >= Math.max(j2.requestTime-tempTime, 0)+j2.needTime? 1:-1);
			lastJob = jobs2.get(0);
			int startTime = Math.max(tempTime, lastJob.requestTime);
			lastJob.endTime = startTime+jobs2.get(0).needTime;
			sum+=(lastJob.endTime-lastJob.requestTime);
			
			System.out.println("["+lastJob.requestTime+", "+lastJob.needTime+"]�� "+startTime+"�� ����, "+lastJob.endTime+"�� ����. "+(lastJob.endTime-lastJob.requestTime)+" �߰���.");
			jobs2.remove(0);
		}
        return sum/jobs.length;
    }
}

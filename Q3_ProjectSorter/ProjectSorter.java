package Q3_ProjectSorter;

import java.util.*;

public class ProjectSorter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.nextLine();  // 버퍼 비우기

        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            int priority = Integer.parseInt(input[1]);
            int time = Integer.parseInt(input[2]);
            projects.add(new Project(name, priority, time));
        }

        // 정렬
        projects.sort((p1, p2) -> {
            if (p1.priority != p2.priority) {  // 우선순위 비교
                return Integer.compare(p1.priority, p2.priority);
            } else if (p1.time != p2.time) {  // 등록 시간 비교
                return Integer.compare(p1.time, p2.time);
            } else {  // 이름 비교
                return p1.name.compareTo(p2.name);
            }
        });

        // 출력
        for (Project project : projects) {
            System.out.println(project.name + " " + project.priority + " " + project.time);
        }
    }

    static class Project {
        String name;
        int priority;
        int time;

        public Project(String name, int priority, int time) {
            this.name = name;
            this.priority = priority;
            this.time = time;
        }
    }
}
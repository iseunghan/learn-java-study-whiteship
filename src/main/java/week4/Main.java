package week4;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Participant> participants;

    private static GHRepository init() throws IOException {
        participants = new ArrayList<>();
        App app = new App();
        GHRepository repository = app.getRepository();

        return repository;
    }

    // list에 해당 유저 이름이 있는지 체크 (return boolean)
    public static Participant isContains(String username) {
        for (Participant participant : participants) {
            if (participant.getUserName().equals(username)) {
                return participant;
            }
        }
        return null;
    }

    public static void check_HomeWork(GHRepository repository) throws IOException {
        for (int i = 1; i <= 18; i++) {
            GHIssue issue = repository.getIssue(i);
            List<GHIssueComment> comments = issue.getComments();

            for (GHIssueComment comment : comments) {
                String userName = comment.getUserName();
                Participant findUser = isContains(userName);
                if (findUser != null) { // 만약 list에 해당 유저가 존재한다?
                    findUser.todayHomeWorkSuccess(i);
                } else {
                    Participant p = new Participant(userName);
                    p.todayHomeWorkSuccess(i);
                    participants.add(p);
                }
//                participants.forEach(e -> {
//                    if (e.getUserName().equals(comment.getUserName())) {
//                        // list에 같은 유저가 있으면?
//                        e.todayHomeWorkSuccess(week); // 이번 i주차 과제 완료!
//                    }else{
//                        Participant p = new Participant(comment.getUserName());
//                        p.todayHomeWorkSuccess(week); // 이번 i주차 과제 완료!
//                        participants.add(p); // list에 넣어준다!
//                    }
//                });
            }
        }
    }

    public static void print_board() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("| 참여자 | 1주차 | 2주차 | 3주차 | 4주차 | 5주차 | 6주차 | 7주차 | 8주차 | 9주차 | 10주차 | 11주차 | 12주차 | 13주차 | 14주차 | 15주차 | 16주차 | 17주차 | 18주차 | 참석율 |\n");
        bw.write("| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |\n");

        for (Participant participant : participants) {
            bw.write("| " + participant.getUserName() + " |");
            int success = participant.getSuccess();
            for (int i = 1; i <= 18; i++) {
                if (participant.is_HW_Done(i)) {
                    bw.write(" ✅ |");
                } else {
                    bw.write(" |");
                }
            }
            double value = (success / (18.0)) * 100;
            bw.write(" " + (Math.round(value * 100) / 100.0) + "% |\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        GHRepository repository = init();
        check_HomeWork(repository); // 과제 했는지 체크!
        print_board(); // 출력
    }
}


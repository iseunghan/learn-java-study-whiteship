package week4;

import org.kohsuke.github.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// De
@Deprecated
public class Github_API {
    static List<Participant> participants = new ArrayList<Participant>();
    public static class App {
        GitHub gitHub = new GitHubBuilder().withOAuthToken("d0556207c6f98154a81ad2d8852dfa7cca51d27a").build();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");

        public GHRepository getRepository() {
            return repository;
        }

        public App() throws IOException {
        }
    }

    public static class Participant {
        String name;
        boolean[] success = new boolean[18];

        public Participant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean[] getSuccess() {
            return success;
        }

        public void setSuccess(boolean[] success) {
            this.success = success;
        }
    }

    public static void printBoard() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("| 참여자 | 1주차 | 2주차 | 3주차 | 4주차 | 5주차 | 6주차 | 7주차 | 8주차 | 9주차 | 10주차 | 11주차 | 12주차 | 13주차 | 14주차 | 15주차 | 16주차 | 17주차 | 18주차 | 참석율 |\n");
        bw.write("| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |\n");

        for (Participant participant : participants) {
            String name = participant.getName();
            boolean[] success = participant.getSuccess();
            bw.write("| " + name);

            for (int i = 0; i < 18; i++) {

                if (success[i]) {
                    bw.write(" :white_check_mark: ");
                } else {
//                    bw.write("");
                }
                bw.write(" |");
            }
            bw.write("\n");
        }


        bw.flush(); bw.close();
    }

    public static void main(String[] args) throws IOException {
        App app = new App();
        GHRepository repository = app.getRepository();
        GHIssue issue = repository.getIssue(4);
        List<GHIssueComment> comments = issue.getComments();

//        for (GHIssueComment comment : comments) {
//            participants.forEach(e ->{
//                if (e.getName().equals(comment.getUserName())) {
//                    boolean[] success = e.getSuccess();
//                    success[4] = true;
//                }else{
//                    participants.add(new Participant(comment.getUserName()));
//                }
//            });
//        }

        for (int i = 1; i <= 18; i++) {
            GHIssue issue1 = repository.getIssue(i);
            List<GHIssueComment> issue1Comments = issue1.getComments();


        }
        for (GHIssueComment comment : comments) {
            Participant participant = new Participant(comment.getUserName());
            boolean[] success = participant.getSuccess();
            success[4] = true;
            participants.add(participant);
        }

        printBoard();
    }
}

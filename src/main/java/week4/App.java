package week4;

import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;

public class App {
    private GitHub gitHub;
    private GHRepository repository;


    // init
    public App() throws IOException {
        gitHub = new GitHubBuilder().withOAuthToken("392d1dc9a302086cbc15dcccca8e07f77a354a1a").build();
//        gitHub = new GitHubBuilder().build();
//        gitHub = GitHub.connect();

        repository = gitHub.getRepository("whiteship/live-study");
    }

    private void setGitHub(GitHub gitHub) {
        this.gitHub = gitHub;
    }

    private void setRepository(GHRepository repository) {
        this.repository = repository;
    }

    public GitHub getGitHub() {
        return gitHub;
    }

    public GHRepository getRepository() {
        return repository;
    }
}
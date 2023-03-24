package notebook;

import notebook.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {
    private static Data instance = new Data();

    private List<Post> posts = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    private Data(){
    }

    public static Data getInstance(){
        return instance;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

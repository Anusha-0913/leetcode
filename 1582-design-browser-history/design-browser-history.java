import java.util.*;

class BrowserHistory {

    List<String> history;
    int curr;

    public BrowserHistory(String homepage) {
        history = new ArrayList<String>();
        history.add(homepage);
        curr = 0;
    }

    public void visit(String url) {
        while (history.size() > curr + 1) {
            history.remove(history.size() - 1);
        }

        history.add(url);
        curr++;
    }

    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }

    public String forward(int steps) {
        curr = Math.min(history.size() - 1, curr + steps);
        return history.get(curr);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory browserHistory = new BrowserHistory(homepage);
 * browserHistory.visit(url);
 * String param_2 = browserHistory.back(steps);
 * String param_3 = browserHistory.forward(steps);
 */
package WebInfo;

import java.util.HashMap;

public class AccountManager {
    private static AccountManager accountManager;
    private HashMap<String, String> info;

    public AccountManager() {
        info = new HashMap<>();
    }

    public synchronized boolean containsAccount(String name){
        return info.containsKey(name);
    }

    public synchronized void addAccount(String name, String password){
        info.put(name, password);
    }

    public synchronized boolean isCorrectAccount(String name, String password){
        if (containsAccount(name) && info.get(name).equals(password)){
            return true;
        }
        return false;
    }

    public static AccountManager getInstance(){
        if (accountManager == null) {
            synchronized (AccountManager.class) {
                if (accountManager == null) {
                    accountManager = new AccountManager();
                }
            }
        }
        return accountManager;
    }
}

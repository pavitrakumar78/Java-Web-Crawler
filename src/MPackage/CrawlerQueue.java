package MPackage;

import java.util.*;

public class CrawlerQueue {

    private List<String> crawledSites = new ArrayList<String>();
    private Queue<String> listOfSites = new LinkedList<String>();
    private HashMap<String, String> content = new HashMap<String, String>();
    private int count;
    
    public synchronized HashMap<String, String> getContent() {
        return content;
    }

    public List<String> getCrawledSites() {
        return crawledSites;
    }

    public synchronized int getQueueLength() {
        return listOfSites.size();
    }

    public synchronized String getNextLink() {
                //remove from top of queue.
        String ret = "";
        try{
            ret = (this.getListOfSites().remove());
        }catch(NoSuchElementException e){
            //System.out.println("Nothing to take!");
        }finally{
            return ret;
        }
    }

    public void addCrawledSites(String url) {
        this.crawledSites.add(url);
    }

    public void setCrawledSites(ArrayList<String> crawledSites) {
        this.crawledSites = crawledSites;
    }

    public synchronized Queue<String> getListOfSites() {
        return listOfSites;
    }

    public void setListOfSites(Queue<String> listOfSites) {
        this.listOfSites = listOfSites;
    }

    public synchronized void addListOfSites(String url) {

        if (!(this.getCrawledSites().contains(url) || this.getListOfSites().contains(url) || url.contains("twitter") || url.contains("facebook") || url.contains("login") || url.contains("signin"))) {
            this.listOfSites.add(url.trim());
        }
    }
    public synchronized void setCount(){
        count = 0;
    }
    public synchronized void incCount(){
        count++;
    }
    public synchronized int getCount(){
        return count;
    }
}

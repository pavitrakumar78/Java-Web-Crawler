package MPackage;

import java.io.IOException;

public class Crawler implements Runnable {

    private int numberOfLinksToCrawl;
    private CrawlerQueue crawledSites;
    private int T;
    private String s;

    public CrawlerQueue getCrawledSites() {
        return crawledSites;
    }

    public void setCrawledSites(CrawlerQueue crawledSites, int numberOfLinksToCrawl) {
        this.crawledSites = crawledSites;
        this.numberOfLinksToCrawl = numberOfLinksToCrawl;
    }

    Crawler(int number) {
        this.numberOfLinksToCrawl = number;

    }

    Crawler(CrawlerQueue crawledSites, int number, int T,String s) {
        this.crawledSites = crawledSites;
        this.numberOfLinksToCrawl = number;
        this.T = T;
        this.s = s;
        System.out.println("Started !--> "+T);
    }

    public int getNumberOfLinksToCrawl() {
        return numberOfLinksToCrawl;
    }

    public void setNumberOfLinksToCrawl(int numberOfLinksToCrawl) {
        this.numberOfLinksToCrawl = numberOfLinksToCrawl;
    }

    @Override
    public void run() {
        //To change body of implemented methods use File | Settings | File Templates.
        try {
            //System.out.println("T->"+T);
            //add the condition crawledSites.getQueueLength()>0 - always kills one thread in the processes
            while ((crawledSites.getCrawledSites().size() < numberOfLinksToCrawl)) {
                HTMLParser.getLinks(crawledSites,T,numberOfLinksToCrawl,s);

            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }

    }
    //notice static!
    public static void initializeCrawling(int numberOfThreads, CrawlerQueue crawledSites, int maximumLimit,String s) {
        
        for (int i = 0; i < numberOfThreads; ++i) {
            new Thread(new Crawler(crawledSites, maximumLimit,i,s)).start();
            System.out.println("Started thread: " + i+s);
        }
    }
}

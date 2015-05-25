/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MPackage;

/**
 *
 * @author pavitrakumar
 */

import static MPackage.Crawler.*;

public class StartCrawler {
    public static void main(String[] args) {
        //Crawler c = new Crawler();
        CrawlerQueue crawledSites = new CrawlerQueue();
        crawledSites.setCount();
        crawledSites.addListOfSites("http://lifehacker.com/");
        //crawledSites.addListOfSites("http://www.minecraft.com");
        crawledSites.addListOfSites("https://en.wikipedia.org/wiki/Main_Page");
        //crawledSites.addListOfSites("http://jsoup.org/cookbook/extracting-data/selector-syntax");
       // crawledSites.addListOfSites("http://www.engadget.com");
       // crawledSites.addListOfSites("https://medium.com/");
        //crawledSites.addListOfSites("http://stackoverflow.com/questions/19596181/how-to-transfer-one-element-from-a-list-to-another-list");
      //  initializeCrawling(3, crawledSites, 100);
      //  while(crawledSites.getStatus()){
        //    System.out.println("Crawled:"+crawledSites.getCount());
       // }

    }
}

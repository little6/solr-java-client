package com.shsz.sms.solr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import com.shsz.sms.solr.beans.Item;

public class HttpSolrServiceTest {
	
	@Test
	public void testSolrService(){
			
		SolrServer server=HttpSolrService.getSolrServer("http://localhost:8080/solr");
		try {
			server.deleteByQuery("*:*");
			 SolrInputDocument doc1 = new SolrInputDocument();
			    doc1.addField( "id", "wyh", 1.0f );
			    doc1.addField( "name", "haohao", 1.0f );
			    doc1.addField( "price", 10 );
			    Collection<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
			    docs.add(doc1);
			    server.add(docs);
			    server.commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	@Test
	public void testSolrServiceByBeans(){
			
		SolrServer server=HttpSolrService.getSolrServer("http://localhost:8080/solr");
		 
			Item item = new Item();
		    item.setId("one");
		    item.setCategories(new String[] { "aaa", "bbb", "ccc" });
		 
		try {
			server.addBean(item);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

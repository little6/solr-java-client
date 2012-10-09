package com.shsz.sms.solr;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;

public class HttpSolrService {
	
	 /**
	  * 
	  * @Title: getCommonsHttpSolrServer
	  * @Description: TODO(http://localhost:8983/solr)
	  * @param: @param url 
	  * @param: @return   
	  * @return: CommonsHttpSolrServer   
	  * @throws
	  */
	public CommonsHttpSolrServer getCommonsHttpSolrServer(String url){
		
		try {
			CommonsHttpSolrServer server = new CommonsHttpSolrServer(url);
			server.setSoTimeout(1000); // socket read timeout
			server.setConnectionTimeout(100);
			server.setDefaultMaxConnectionsPerHost(100);
			server.setMaxTotalConnections(100);
			server.setFollowRedirects(false); // defaults to false
			// allowCompression defaults to false.
			// Server side must support gzip or deflate for this to have any
			// effect.
			server.setAllowCompression(true);
			server.setMaxRetries(1); // defaults to 0. > 1 not recommended.
			server.setParser(new XMLResponseParser()); // binary parser is used
														// by default
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
		
		 
	}
		/**
		 * 
		 * @Title: getSolrServer
		 * @Description: TODO(封装静态的方法获取 {@code SolrServer} 对象)
		 * @param: @param url solr 服务器地址
		 * @param: @return   {@code SolrServer}
		 * @return: SolrServer   
		 * @throws
		 */
	public static SolrServer getSolrServer(String url){
		
		SolrServer server = null;
		try {
			if(server==null){
				return new CommonsHttpSolrServer(url);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return server;
	}
	
	
}

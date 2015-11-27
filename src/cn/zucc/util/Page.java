package cn.zucc.util;

public class Page {
	
		public static final int pageSize=5;
		
		public static int totalCount(int Pagecount){
			if(Pagecount ==0){
				return 1;
			}else if(Pagecount % pageSize ==0){
				return Pagecount/pageSize;
				}else{return Pagecount/pageSize +1;}	
		}
		public static int pageNo(int pageNo){
			return (pageNo-1)*pageSize;
		}
		
}

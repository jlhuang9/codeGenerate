package com.motorsc.match.common.tool;
import java.util.List;

/**
 * 基本分页返回消息类
 * @author LiJiaShu
 * @param <T>
 */
public class PageResult<T> extends ListResult<T>{

	private static final long serialVersionUID = -875667238896024159L;
	
	
	private int page = Base.DEFAULT_PAGE;
	private int pageSize = Base.DEFAULT_PAGE_SIZE;
	
	private int totalPage;
	
	private Long total;
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page>0){
			this.page = page;
		}else{
			this.page = Base.DEFAULT_PAGE;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if(pageSize>0){
			this.pageSize = pageSize;
		}else{
			this.pageSize = Base.DEFAULT_PAGE_SIZE;;
		}
		resizePage();
	}
	
	public int getTotalPage() {
		return totalPage;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		if(total<0){
			total = 0L;
		}
		this.total = total;
		resizePage();
	}
	
	public void setTotal(int total) {
		if(total<0){
			total = 0;
		}
		this.total = new Long(total);
		resizePage();
	}

	private void resizePage(){
		if (null==total||total <= 0) { 
			this.totalPage = 0;
		} else { // 计算总页数
			int t = (int) (total /this.getPageSize());
			int y = total % this.getPageSize() == 0 ? 0 : 1;
			this.totalPage = t+y;
		}
	}
	
	public static <T> PageResult<T> getPageSuccessInstance(List<T> data, String msg, int code, long total) {
		PageResult<T> r = new PageResult<T>();
		r.setResult(true);
		r.setMessage(msg);
		r.setCode(code);
		r.setListData(data);
		r.setTotal(total);
		return r;
	}
	public static <T> PageResult<T> getPageSuccessInstance(List<T> data, String msg, int code, long total, int pageSize, int page) {
		PageResult<T> r = new PageResult<T>();
		r.setResult(true);
		r.setMessage(msg);
		r.setCode(code);
		r.setListData(data);
		r.setTotal(total);
		r.setPageSize(pageSize);
		r.setPage(page);
		return r;
	}
	
	public static <T> PageResult<T> getPageSuccessInstance(List<T> data, String msg, long total, Base dto) {
		PageResult<T> r = new PageResult<T>();
		r.setResult(true);
		r.setMessage(msg);
		r.setCode(ConstCode.OPERAT_SUCCESS);
		r.setListData(data);
		r.setTotal(total);
		r.setPageSize(dto.getPageSize());
		r.setPage(dto.getPage());
		return r;
	}
	
	public static <T> PageResult<T> getPageFailureInstance(String msg, int code) {
		PageResult<T> r = new PageResult<T>();
		r.setResult(false);
		r.setMessage(msg);
		r.setCode(code);
		r.setTotal(0);
		return r;
	}
}

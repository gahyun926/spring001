package com.human.vo;

public class PageVO {
	   private int startNo;// �Խ������̺�,ȸ�����̺��� �ʵ�ʹ� �����������.
	   private int endNo;
	   private int perPageNum=10;
	   private Integer page;// jsp�ܿ��� null�� ���� �ö� ������ �߻����� �ʵ��� Integer���
	   private int totalCount;
	   private int endPage;
	   private int startPage;
	   private boolean prev;
	   private boolean next;
	   // �˻��� ���� 2�� �߰�
	   private String searchType;
	   private String searchKeyword;

	   public int getEndNo() {
	      return endNo;
	   }

	   public void setEndNo(int endNo) {
	      this.endNo = endNo;
	   }

	   public String getSearchType() {
	      return searchType;
	   }

	   public void setSearchType(String searchType) {
	      this.searchType = searchType;
	   }

	   public String getSearchKeyword() {
	      return searchKeyword;
	   }

	   public void setSearchKeyword(String searchKeyword) {
	      this.searchKeyword = searchKeyword;
	   }

	   private void calcPage() {
	      // DB�������� ���... ���۵����͹�ȣ = (jspŬ���� ��������ȣ-1)*�������� �������� ����
	      startNo = (this.page - 1) * perPageNum +1;
	      // page������ ���� jsp���� Ŭ���� ��������ȣ
	      int tempEnd = (int) (Math.ceil(page / (double) this.perPageNum) * this.perPageNum);
	      // ceil�Լ��� õ�� �Լ��� 1.1 = 2, 2.1 = 3 ���� ��µȴ�.
	      // �ݴ�Ǵ� �ٴ��Լ��� floor(), �ݿø� �Լ��� round()�� �ִ�.
	      // jsp���� Ŭ���� ��������ȣ�� �������� �� �������� ����Ѵ�.
	      this.startPage = (tempEnd - this.perPageNum) + 1;
	      // ���� ������ ��� Ŭ����page��ȣ 10�϶� ���� ������������ 1
	      if (tempEnd * this.perPageNum > this.totalCount) {
	         // Ŭ���� page��ȣ�� ���� �Խù����� �����Խù����� totalCount Ŭ��
	         this.endPage = (int) Math.ceil(this.totalCount / (double) this.perPageNum);
	        // this.endNo = startNo + this.perPageNum - 1;
	         if(endPage!=page) {
		    	  this.endNo = startNo + this.perPageNum - 1;
		      }else {
		    	  this.endNo = startNo + this.totalCount % 10 - 1;
		      }
	      } else {
	         // Ŭ���� page��ȣ�� ���� �Խù����� �����Խù����� totalCount ������
	         this.endPage = tempEnd;
	         this.endNo = startNo + this.perPageNum - 1;
	         //this.endNo = startNo + this.totalCount % 10 - 1;
	      }
	     
	      this.prev = this.startPage != 1;// ���������� 1���� ũ�� ������ ���� �������� ����. true
	      this.next = this.endPage * this.perPageNum < this.totalCount;
	      // Ŭ���� page��ȣ�� ���� �Խù����� ���� �Խù� �������� �۴ٸ� ������������ ����. true
	   }

	   public int getTotalCount() {
	      return totalCount;
	   }

	   public void setTotalCount(int totalCount) {
	      this.totalCount = totalCount;
	      calcPage();// totalCount �����Խù������� �־���� ����������� �� �� �ֱ� ������
	   }

	   public int getEndPage() {
	      return endPage;
	   }

	   public void setEndPage(int endPage) {
	      this.endPage = endPage;
	   }

	   public int getStartPage() {
	      return startPage;
	   }

	   public void setStartPage(int startPage) {
	      this.startPage = startPage;
	   }

	   public boolean isPrev() {
	      return prev;
	   }

	   public void setPrev(boolean prev) {
	      this.prev = prev;
	   }

	   public boolean isNext() {
	      return next;
	   }

	   public void setNext(boolean next) {
	      this.next = next;
	   }

	   public Integer getPage() {
	      return page;
	   }

	   public void setPage(Integer page) {
	      this.page = page;
	   }

	   public int getStartNo() {

	      return startNo;
	   }

	   public void setStartNo(int startNo) {
	      this.startNo = startNo;
	   }

	   public int getPerPageNum() {
	      return perPageNum;
	   }

	   public void setPerPageNum(int perPageNum) {
	      this.perPageNum = perPageNum;
	   }
}

package com.globus.util;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

public class EndlessGridAndHideFooterRecyclerScrollChangeListener extends RecyclerView.OnScrollListener {
	private static final int HIDE_THRESHOLD= 4;
	private int scrolledDistance = 0;
	private boolean controlsVisible = true;
	private int previousTotal = 0; // The total number of items in the dataset after the last load
    private boolean loading = true; // True if we are still waiting for the last set of data to load.
    private int visibleThreshold = 5; // The minimum amount of items to have below your current scroll position before loading more.
    private int firstVisibleItem, visibleItemCount, totalItemCount;
    private int current_page = 1;
    private GridLayoutManager mGridLayoutManager;
    
    public EndlessGridAndHideFooterRecyclerScrollChangeListener(GridLayoutManager mGridLayoutManager) {
		super();
		this.mGridLayoutManager = mGridLayoutManager;
	}

	@Override
	public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
		super.onScrolled(recyclerView, dx, dy);
		
		visibleItemCount= recyclerView.getChildCount();
		totalItemCount= this.mGridLayoutManager.getChildCount();
		firstVisibleItem= this.mGridLayoutManager.findFirstVisibleItemPosition();
		
		if(loading){
			if (totalItemCount > previousTotal) {
				loading= false;
				previousTotal= totalItemCount;
			}
		}
		
		if(!loading && (totalItemCount- visibleItemCount) <= (firstVisibleItem+ visibleThreshold)){
			current_page++;
			onLoadMore(current_page);
			loading= true;
		}
		
		//Show or hide footer view (filter and sort)
		if(scrolledDistance > HIDE_THRESHOLD && controlsVisible){
			onHideFooterView();
			controlsVisible= false;
			scrolledDistance= 0;
		}else if(scrolledDistance < -HIDE_THRESHOLD && !controlsVisible){
			onShowFooterView();
			controlsVisible= true;
			scrolledDistance= 0;
		}
		
		if((controlsVisible && dy>0) || (!controlsVisible && dy<0)) {
		      scrolledDistance += dy;
		    }
	}

	public void onLoadMore(int current_page) {
	}

	public void onShowFooterView() {
	}

	public void onHideFooterView() {
	}
}

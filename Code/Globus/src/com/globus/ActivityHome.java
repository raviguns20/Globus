package com.globus;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.globus.adapter.AdapterHomeViewPageAdapter;
import com.globus.adapter.AdapterHomepageBlocks;
import com.android.volley.toolbox.NetworkImageView;
import com.globus.adapter.AdapterHomeCategory;
import com.globus.adapter.AdapterHomeGridAdapter;
import com.globus.adapter.AdapterHomePramotions;
import com.globus.base.BaseClass;
import com.globus.fragments.FragmentLogin;
import com.globus.fragments.FragmentMainCategory;
import com.globus.fragments.FragmentSubCategory;
import com.globus.material.api.ToolbarManager;
import com.globus.material.util.ThemeUtil;
import com.globus.model.ModelBanners;
import com.globus.model.ModelCategory;
import com.globus.model.ModelHeaderImage;
import com.globus.model.ModelHome;
import com.globus.model.ModelHomepageBlocks;
import com.globus.model.ModelPromotions;
import com.globus.model.ModelStores;
import com.globus.servercall.HttpVolleyRequest;
import com.globus.servercall.JsonParserUtil;
import com.globus.servercall.MyListener;
import com.globus.util.Constant;
import com.globus.util.IOUtils;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ActivityHome extends BaseClass implements ToolbarManager.OnToolbarGroupChangedListener ,OnClickListener, OnPageChangeListener{

	private DrawerLayout dl_navigator;
	private FrameLayout fl_drawer;
	private ListView lv_drawer;
	private LinearLayout btnSearchProduct;
	private DrawerAdapter mDrawerAdapter;
	private RelativeLayout btnOpenDrawer;
	private Toolbar mToolbar;
	private ToolbarManager mToolbarManager;
	private ImageView imgProfile,imgNotification,imgCart;
	private NetworkImageView imgStoreImage;
	private Tab[] mItems = new Tab[]{Tab.PROGRESS, Tab.BUTTONS, Tab.FAB, Tab.SWITCHES, Tab.SLIDERS, Tab.SPINNERS, Tab.TEXTFIELDS, Tab.SNACKBARS, Tab.DIALOGS};

	private ViewPager viewPager;
	private LinearLayout viewPagerIndicatorLL,linHomepageBlocks;
	private int dotsCount,homeBlockCounts=11,noOfRow=0;
	private ImageView[] dots;
	private LinearLayout rootView=null;
	private GridView gridHomepageBlocks;
	//	private RecyclerView recycleViewHeader;
	private GridView recycleViewHeader;

	private ScrollView scrollHome;
	private RecyclerView recyclerViewPromotions;
	private TextView txtHomeBlocks,txtPromotions,txtStores;
	private AdapterHomeViewPageAdapter mAdapterViewPager;
	private AdapterHomepageBlocks mAdapterHomepageBlocks;
	private AdapterHomePramotions mAdapterHomePramotions;
	private AdapterHomeCategory mAdapterHomeCategory;
	ImageView img_profile_icon;

	private ModelHome modelHome=new ModelHome();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		setUI();
		
		mDrawerAdapter = new DrawerAdapter();
		lv_drawer.setAdapter(mDrawerAdapter);
		mDrawerAdapter.setSelected(Tab.PROGRESS);
		JSONObject jsonRequest = new JSONObject();
		try {
			jsonRequest.put(Constant.CUST_USER_EMAIL,"satyendraiksula@gmail.com");
			jsonRequest.put(Constant.USER_ID,"25562");
			jsonRequest.put(Constant.API_KEY,"aazfcsdzfcvsdazgvsagdvsfdgvsfdgvfds");
			jsonRequest.put(Constant.API_USERNAME,"test");
			jsonRequest.put(Constant.WEBSITE_ID,"1");
			jsonRequest.put(Constant.CURRENCY,"INR");
			jsonRequest.put(Constant.LANGUAGE,"USD");

		} catch (JSONException e) {
			e.printStackTrace();
		}
		if (IOUtils.isInternetPresent(BASE_CONTEXT)) {
			new HttpVolleyRequest(BASE_CONTEXT, jsonRequest, Constant.URL_HOME, listener);
		} else {
			IOUtils.mySnackBarInternet(BASE_CONTEXT, rootView);
		}
	}
	private void setPromotions(ArrayList<ModelPromotions> arrayList) {

		LinearLayoutManager layoutManager= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		recyclerViewPromotions.setLayoutManager(layoutManager);
		mAdapterHomePramotions=new AdapterHomePramotions(ActivityHome.this, arrayList.get(0).getModelProduct());
		recyclerViewPromotions.setAdapter(mAdapterHomePramotions);
	}
	private void setHomeBlock(ArrayList<ModelBanners> arrayList) {
		homeBlockCounts=arrayList.size();
		mAdapterHomepageBlocks=new AdapterHomepageBlocks(ActivityHome.this, arrayList);
		ViewTreeObserver vto = scrollHome.getViewTreeObserver();
		vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			@Override
			public void onGlobalLayout() {
				scrollHome.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				//int	mGridHeight = (int) (gridHomepageBlocks.getHeight() / 2.2f);
				gridHomepageBlocks.setAdapter(mAdapterHomepageBlocks);
				LayoutParams param = gridHomepageBlocks.getLayoutParams();
				int	individualItemHeight=(IOUtils.getHieghtOfScreen(ActivityHome.this)/2)+(100*(int)getResources().getDisplayMetrics().density);
				if(homeBlockCounts%2==0) {
					noOfRow=homeBlockCounts/2;
				}
				else {
					noOfRow=(homeBlockCounts/2)+1;
				}

				param.height=(noOfRow*individualItemHeight)+(50*(int)getResources().getDisplayMetrics().density);
				param.width=android.app.ActionBar.LayoutParams.MATCH_PARENT;
				gridHomepageBlocks.setLayoutParams(param);
				gridHomepageBlocks.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
						startActivity(new Intent(ActivityHome.this, ActivitySubCategory.class));
					}
				});
			}
		});

	}
	private void setHeader(ArrayList<ModelHeaderImage> listOfImages) {
		/*LinearLayoutManager layoutManager
		= new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		recycleViewHeader.setLayoutManager(layoutManager);
		mAdapterHomeCategory=new AdapterHomeCategory(ActivityHome.this, listOfImages);
		recycleViewHeader.setAdapter(mAdapterHomeCategory);	
		 */
		AdapterHomeGridAdapter gridAdapter=new AdapterHomeGridAdapter(ActivityHome.this, listOfImages)	;
		recycleViewHeader.setAdapter(gridAdapter);
		recycleViewHeader.setNumColumns(listOfImages.size());
		recycleViewHeader.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
				startActivity(new Intent(ActivityHome.this, ActivitySubCategory.class));
			}
		});
	}
	MyListener listener=new MyListener() {

		@Override
		public void success(Object obj) {
			scrollHome.setVisibility(View.VISIBLE);
			System.out.println(obj+"");
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject(obj.toString());
				modelHome=JsonParserUtil.getHomeResponse(jsonObject, ActivityHome.this);
				//	if(modelHome.getStatus().equalsIgnoreCase("1")) {
				if(modelHome.getModelCategory().size()>0) {

				}
				if(modelHome.getModelBanners().size()>0) {
					setUiPageViewController(modelHome.getModelBanners());

				}
				if(modelHome.getModelHeaderImage().size()>0) {
					setHeader(modelHome.getModelHeaderImage());
				}
				if(modelHome.getModelHomepageBlocks()!=null) {
					ModelHomepageBlocks homePageBlocks=modelHome.getModelHomepageBlocks();
					txtHomeBlocks.setText(homePageBlocks.getHeader()+"");
					setHomeBlock(homePageBlocks.getModelBanners());

				}
				if(modelHome.getModelPromotions().size()>0) {
					txtPromotions.setText(modelHome.getModelPromotions().get(0).getTitle()+"");
					setPromotions(modelHome.getModelPromotions());
				}
				if(modelHome.getModelStores()!=null) {
					ModelStores modelStores=modelHome.getModelStores();
					if(modelStores.getHeader()!=null)
						txtStores.setText(modelStores.getHeader()+"");
					IOUtils.setImageToNetworkImageView(imgStoreImage, modelStores.getImageUrl());

				}
				//	}s


			} catch (JSONException e) {

				e.printStackTrace();
				scrollHome.setVisibility(View.GONE);
				IOUtils.myToastLong(getResources().getString(R.string.msg_internet_connection), getApplicationContext());
			}
		}

		@Override
		public void failure(Object obj) {
			scrollHome.setVisibility(View.GONE);
			IOUtils.myToastLong(getResources().getString(R.string.msg_internet_connection), getApplicationContext());

		}
	};

	private void setUI() {	
		BASE_CONTEXT=ActivityHome.this;
		scrollHome=(ScrollView) findViewById(R.id.scroll_home);
		recyclerViewPromotions=(RecyclerView) findViewById(R.id.recyclerView);
		txtHomeBlocks=(TextView) findViewById(R.id.header_home_homeblocks);
		txtPromotions=(TextView) findViewById(R.id.header_home_promotion);
		txtStores=(TextView) findViewById(R.id.header_home_stores);
		imgStoreImage=(NetworkImageView) findViewById(R.id.imgStoreImage);
		recycleViewHeader=(GridView) findViewById(R.id.recyclerviewHeader);

		gridHomepageBlocks=(GridView) findViewById(R.id.grid_home_homepageblocks);
		linHomepageBlocks=(LinearLayout) findViewById(R.id.lin_home_homepageblocks);
		rootView=(LinearLayout) findViewById(R.id.rootView);
		dl_navigator = (DrawerLayout)findViewById(R.id.main_dl);
		fl_drawer = (FrameLayout)findViewById(R.id.main_fl_drawer);
		mToolbar = (Toolbar)findViewById(R.id.main_toolbar);
		btnOpenDrawer = (RelativeLayout)findViewById(R.id.rel_drawer_btn);
		btnOpenDrawer.setOnClickListener(this);
		lv_drawer = (ListView)findViewById(R.id.main_lv_drawer);
		imgProfile=(ImageView) mToolbar.findViewById(R.id.img_profile_icon);
		imgProfile.setOnClickListener(this);
		imgNotification=(ImageView) mToolbar.findViewById(R.id.img_notification);
		imgNotification.setOnClickListener(this);
		btnSearchProduct=(LinearLayout) findViewById(R.id.lin_serach_prod);
		btnSearchProduct.setOnClickListener(this);
		//	recycleViewHeader=(RecyclerView) findViewById(R.id.recyclerviewHeader);
		viewPager = (ViewPager)findViewById(R.id.viewPager);
		viewPagerIndicatorLL = (LinearLayout)findViewById(R.id.viewPagerIndicatorLL);
		
		img_profile_icon=(ImageView)findViewById(R.id.img_profile_icon);
		img_profile_icon.setOnClickListener(this);
		displayView(0,"initial");
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//	mToolbarManager.createMenu(R.menu.menu_main);
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		//mToolbarManager.onPrepareMenu();
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return true;
	}

	@Override
	public void onToolbarGroupChanged(int oldGroupId, int groupId) {
		//mToolbarManager.notifyNavigationStateChanged();
	}



	public enum Tab {
		PROGRESS ("view1"),
		BUTTONS ("view1"),
		FAB ("view1"),
		SWITCHES ("view1"),
		SLIDERS ("view1"),
		SPINNERS ("view1"),
		TEXTFIELDS ("view1"),
		SNACKBARS ("view1"),
		DIALOGS ("view1");
		private final String name;       

		private Tab(String s) {
			name = s;
		}

		public boolean equalsName(String otherName){
			return (otherName != null) && name.equals(otherName);
		}

		public String toString(){
			return name;
		}

	}

	class DrawerAdapter extends BaseAdapter implements View.OnClickListener {

		private Tab mSelectedTab;

		public void setSelected(Tab tab){
			if(tab != mSelectedTab){
				mSelectedTab = tab;
				notifyDataSetInvalidated();
			}
		}

		public Tab getSelectedTab(){
			return mSelectedTab;
		}

		@Override
		public int getCount() {
			return mItems.length;
		}

		@Override
		public Object getItem(int position) {
			return mItems[position];
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View v = convertView;
			if(v == null) {
				v = LayoutInflater.from(ActivityHome.this).inflate(R.layout.row_drawer, null);
				v.setOnClickListener(this);
			}

			v.setTag(position);
			Tab tab = (Tab)getItem(position);
			((TextView)v).setText(tab.toString());

			if(tab == mSelectedTab) {
				v.setBackgroundColor(ThemeUtil.colorPrimary(ActivityHome.this, 0));
				((TextView)v).setTextColor(0xFFFFFFFF);
			}
			else {
				v.setBackgroundResource(0);
				((TextView)v).setTextColor(0xFF000000);
			}

			return v;
		}

		@Override
		public void onClick(View v) {
			int position = (Integer)v.getTag();
			dl_navigator.closeDrawer(fl_drawer);
		}
	}

	@Override
	public void onClick(View v) {
		Intent intent=null;
		switch (v.getId()) {
		case R.id.lin_serach_prod:
			intent =new Intent(this,ActivitySearchProduct.class);
			startActivity(intent);
			break;
		case R.id.img_profile_icon:
			intent =new Intent(this,ActivityMyAccount.class);
			startActivity(intent);
			break;
		case R.id.rel_drawer_btn:
			dl_navigator.openDrawer(GravityCompat.START);
			break;
		case R.id.img_profile_cart:

			break;
		case R.id.img_notification:

			break; 
		default:
			break;
		}		
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {

	}

	@Override
	public void onPageScrolled(int position, float arg1, int arg2) {
		// TODO Auto-generated method stub
		for (int i = 0; i < dotsCount; i++) {
			dots[i].setImageDrawable(getResources().getDrawable(R.drawable.shape_dot_nonselected));
		}

		dots[position].setImageDrawable(getResources().getDrawable(R.drawable.shape_dot_selected));
	}

	@Override
	public void onPageSelected(int arg0) {
	}

	private void setUiPageViewController(ArrayList<ModelBanners> arrayList) {
		mAdapterViewPager = new AdapterHomeViewPageAdapter(this, arrayList);
		viewPager.setAdapter(mAdapterViewPager);
		viewPager.setCurrentItem(0);
		viewPager.setOnPageChangeListener(this);

		dotsCount = mAdapterViewPager.getCount();
		dots = new ImageView[dotsCount];

		for (int i = 0; i < dotsCount; i++) {	
			dots[i] = new ImageView(this);
			dots[i].setImageDrawable(getResources().getDrawable(R.drawable.shape_dot_nonselected));

			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.WRAP_CONTENT,
					LinearLayout.LayoutParams.WRAP_CONTENT
					);

			params.setMargins(4, 0, 4, 0);

			viewPagerIndicatorLL.addView(dots[i], params);
		}
		dots[0].setImageDrawable(getResources().getDrawable(R.drawable.shape_dot_selected));
	}   
	
	
	public void displayView(int position, String hint) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new FragmentMainCategory();
                break;
            case 1:
                fragment = new FragmentSubCategory();
                break;
           
            default:
                break;
        }
 
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            
			if (TextUtils.isEmpty(hint)) {
				if (position == 0)
					fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right);
				else if (position == 1)
					fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
					
			}
			
            fragmentTransaction.replace(R.id.main_fl_drawer, fragment);
            fragmentTransaction.commit();
        }
    }
	
}

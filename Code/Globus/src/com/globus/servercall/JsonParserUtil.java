package com.globus.servercall;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.globus.R;
import com.globus.model.ModelBanners;
import com.globus.model.ModelCart;
import com.globus.model.ModelCartProduct;
import com.globus.model.ModelCategory;
import com.globus.model.ModelHeaderImage;
import com.globus.model.ModelHome;
import com.globus.model.ModelHomepageBlocks;
import com.globus.model.ModelOptions;
import com.globus.model.ModelPrice;
import com.globus.model.ModelProduct;
import com.globus.model.ModelPromotions;
import com.globus.model.ModelStores;
import com.globus.model.ModelTotal;
import com.globus.model.ModelUser;
import com.globus.util.Constant;
import com.globus.util.IOUtils;
import com.globus.util.PreferenceConnector;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class JsonParserUtil {
	static String returnString=null;
	static String Message=null;
	private static ArrayList<ModelCartProduct> arrayListProduct;
	//---------------------------- LOGIN RESPONSE -----------------------------
		public static String getLoginResponse(JSONObject jsonObject,Context mContext){
			AppCompatActivity activity=(AppCompatActivity)mContext;
			try {
				
				if(jsonObject.has(Constant.MESSAGE)){
					Message=jsonObject.getString(Constant.MESSAGE);
				}
				if (jsonObject.getString(Constant.STATUS).equals("0")) {
					IOUtils.mySnackBar(mContext, Message, (LinearLayout)activity.findViewById(R.id.rootView));
					return null;
				} else if (jsonObject.getString(Constant.STATUS).equals("1")) {
					
					IOUtils.mySnackBar(mContext, mContext.getString(R.string.login_successfull), (LinearLayout)activity.findViewById(R.id.rootView));
					/*if (TextUtils.isEmpty(Message)) {
				    	IOUtils.mySnackBar(mContext, mContext.getString(R.string.login_successfull), (LinearLayout)activity.findViewById(R.id.rootView));
					} else {
				    		IOUtils.mySnackBar(mContext, Message, (LinearLayout)activity.findViewById(R.id.rootView));
				    }*/
					JSONObject joInner=jsonObject.getJSONObject("User");
					ModelUser recordUser=new ModelUser(); 
					
					String UserId=joInner.getString(Constant.USER_ID);
					String UserName=joInner.getString(Constant.CUST_USER_NAME);
					String UserEmail=joInner.getString(Constant.CUST_USER_EMAIL);
					String CartQty=joInner.getString(Constant.CUST_CART_QTY);
					
					recordUser.setUserId(UserId);
					recordUser.setUserEmail(UserEmail);
					recordUser.setUserName(UserName);
					recordUser.setCartQty(Integer.valueOf(CartQty));
					PreferenceConnector.saveUser(mContext, recordUser);
					
					return "success";
					  
				}
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
		}
		
		
		 //---------------------------- SOCIAL LOGIN RESPONSE -----------------------------
			public static String getSocialLoginResponse(JSONObject jsonObject,Context mContext){
				AppCompatActivity activity=(AppCompatActivity)mContext;
				try {
					
					if(jsonObject.has(Constant.MESSAGE)){
						Message=jsonObject.getString(Constant.MESSAGE);
					}
					
					if (jsonObject.getString(Constant.STATUS).equals("0")) {
						IOUtils.mySnackBar(mContext, Message, (LinearLayout)activity.findViewById(R.id.rootView));
						return null;
					}
				    else if (jsonObject.getString(Constant.STATUS).equals("1")) {
					
				     IOUtils.mySnackBar(mContext, mContext.getString(R.string.login_successfull), (LinearLayout)activity.findViewById(R.id.rootView));
				    	
					/*if (TextUtils.isEmpty(Message)) {
				    	IOUtils.mySnackBar(mContext, mContext.getString(R.string.login_successfull), (LinearLayout)activity.findViewById(R.id.rootView));
					} else {
				    		IOUtils.mySnackBar(mContext, Message, (LinearLayout)activity.findViewById(R.id.rootView));
				     }
				    */
				    	
						JSONObject joInner=jsonObject.getJSONObject("User");
						ModelUser recordUser=new ModelUser(); 
						
						String UserId=joInner.getString(Constant.USER_ID);
						String UserName=joInner.getString(Constant.CUST_USER_NAME);
						String UserEmail=joInner.getString(Constant.CUST_USER_EMAIL);
						String CartQty=joInner.getString(Constant.CUST_CART_QTY);
						
						recordUser.setUserId(UserId);
						recordUser.setUserEmail(UserEmail);
						recordUser.setUserName(UserName);
						recordUser.setCartQty(Integer.valueOf(CartQty));
						PreferenceConnector.saveUser(mContext, recordUser);
						return "success";
						  
					}
					
			} catch (JSONException e) {
				e.printStackTrace();
			}
				return null;
			}
		
		//---------------------------- REGISTER RESPONSE -----------------------------
		public static String getRegisterResponse(JSONObject jsonObject,Context mContext){
			String returnString=null;
			AppCompatActivity activity=(AppCompatActivity)mContext;
			try {
				Message=jsonObject.getString(Constant.MESSAGE);
				if(jsonObject.getString(Constant.STATUS).equals("0")){
					IOUtils.mySnackBar(mContext, Message, (LinearLayout)activity.findViewById(R.id.rootView));
					return null;
				}else if(jsonObject.getString(Constant.STATUS).equals("1")){
					IOUtils.mySnackBar(mContext, Message, (LinearLayout)activity.findViewById(R.id.rootView));
					JSONObject joInner=jsonObject.getJSONObject("User");
					ModelUser recordUser=new ModelUser();
					
					String UserId=joInner.getString(Constant.USER_ID);
					String UserName=joInner.getString(Constant.CUST_USER_NAME);
					String UserEmail=joInner.getString(Constant.CUST_USER_EMAIL);
					String CartQty=joInner.getString(Constant.CUST_CART_QTY);
					
					recordUser.setUserId(UserId);
					recordUser.setUserEmail(UserEmail);
					recordUser.setUserName(UserName);
					recordUser.setCartQty(Integer.valueOf(CartQty));
					PreferenceConnector.saveUser(mContext, recordUser);
					return "success";
					
				}
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return returnString;
			
		}
	//------------------------ GET CART ITEMS ----------------------------------
		
		public static ModelCart getCheckOutCartResponse(JSONObject jsonObject,Context mContext){
			
			ModelCart recordCart=new ModelCart();
			String rewardPoint=null;
			ArrayList<ModelCartProduct> arrayListCartProduct=new ArrayList<ModelCartProduct>();
			
			AppCompatActivity activity=(AppCompatActivity)mContext;
			try {
				Message=jsonObject.getString(Constant.MESSAGE);
				if(jsonObject.getString(Constant.STATUS).equals("0")){
					IOUtils.mySnackBar(mContext, Message, (LinearLayout)activity.findViewById(R.id.rootView));
					return null;
				}else if(jsonObject.getString(Constant.STATUS).equals("1")){
					
					if (jsonObject.has(Constant.CART_REWARDPOINTS)) {
						rewardPoint = jsonObject.getString(Constant.CART_REWARDPOINTS);
						recordCart.setRewardPoints(Double.valueOf(rewardPoint)); //-- REWARD POINT ADDEDE
					}
					
					//----------- CART PRODUCT ITEMS ---------------------
					JSONArray jaCart=jsonObject.getJSONArray("CART");
					
					for(int i=0;i<jaCart.length();i++){
						JSONObject joInner = jaCart.getJSONObject(i);
						ModelCartProduct recordProductCart=new ModelCartProduct();
					
						recordProductCart.setCartItemId(Integer.valueOf(joInner.getString(Constant.CART_CARTITEMID)));
						recordProductCart.setProductId(Integer.valueOf(joInner.getString(Constant.CART_PRODUCTID)));
						recordProductCart.setProductImage(joInner.getString(Constant.CART_PRODUCTIMAGE));
						recordProductCart.setProductMaxQty(Integer.valueOf(joInner.getString(Constant.CART_PRODUCTMAXQTY)));
						recordProductCart.setProductName(joInner.getString(Constant.CART_PRODUCTNAME));
						recordProductCart.setProductPrice(Double.valueOf(joInner.getString(Constant.CART_PRODUCTPRICE)));
						recordProductCart.setProductQty(Integer.valueOf(joInner.getString(Constant.CART_PRODUCTMAXQTY)));
						
						//------------------- OPTION JSON ARRAY -------------------
						ModelOptions recordOption=new ModelOptions();
						JSONArray jaOption=joInner.getJSONArray("Options");
						if(jaOption.length()>0){
						}
						
						recordProductCart.setRecordOption(recordOption);
						arrayListCartProduct.add(recordProductCart);
						recordCart.setModelCartProduct(arrayListCartProduct); //--- PRODUCT LIST ADDED
					}
					
					//----------- CART TOTAL ---------------------
					JSONObject joTotal=jsonObject.getJSONObject("Totals");
							
					ModelTotal recordTotal=new ModelTotal();
					recordTotal.setSubtotal(Double.valueOf(joTotal.getString(Constant.CHECKOUT_SUBTOTAL)));
					recordTotal.setGrandTotal(Double.valueOf(joTotal.getString(Constant.CHECKOUT_GRANDTOTAL)));
					recordTotal.setDiscount(Double.valueOf(joTotal.getString(Constant.CHECKOUT_DISCOUNT)));
					recordTotal.setShippingHand(Integer.valueOf(joTotal.getString(Constant.CHECKOUT_SHIPPINGHAND)));
				
					recordCart.setModelTotal(recordTotal); //--- TOTAL ADDED
				}
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return recordCart;
		}
		
		
		
		//---------------------------- FORGOT PASSWORD  RESPONSE -----------------------------
			public static String getForgotPasswordResponse(JSONObject jsonObject,Context mContext){
				AppCompatActivity activity=(AppCompatActivity)mContext;
				try {
					Message=jsonObject.getString(Constant.MESSAGE);
					if(jsonObject.getString(Constant.STATUS).equals("0")){
						IOUtils.mySnackBar(mContext, Message, (LinearLayout)activity.findViewById(R.id.rootView));
						return null;
					}else if(jsonObject.getString(Constant.STATUS).equals("1")){
						return "success";
					}
					
				} catch (JSONException e) {
					e.printStackTrace();
				}
				return null;
			}

	//----------------------------HOME RESPONSE -----------------------------
	public static ModelHome getHomeResponse(JSONObject jsonObject,Context mContext){

		ModelHome modelHome = new ModelHome();
		ModelHomepageBlocks modelHomepageBlocks = new ModelHomepageBlocks();
		ModelPromotions recordPromotions=new ModelPromotions();
		ModelStores modelStores = new ModelStores();
		ArrayList<ModelHeaderImage> arrayListHeaderImage=new ArrayList<ModelHeaderImage>();
		ArrayList<ModelBanners> arrayListBanners=new ArrayList<ModelBanners>();
		ArrayList<ModelBanners> arrayListContent=new ArrayList<ModelBanners>();
		ArrayList<ModelPromotions> arrayListPromotions=new ArrayList<ModelPromotions>();
		ArrayList<ModelProduct> arrayListProduct=new ArrayList<ModelProduct>();
		ArrayList<ModelCategory> arrayListCategory=new ArrayList<ModelCategory>();
		AppCompatActivity activity=(AppCompatActivity)mContext;

		try {
			if(!jsonObject.isNull(Constant.CURRENCY))
				modelHome.setCurrency(jsonObject.getString(Constant.CURRENCY));
			if(!jsonObject.isNull(Constant.HOME_CARTQTY))
				modelHome.setCartQty(jsonObject.getString(Constant.HOME_CARTQTY));
			if(jsonObject.getInt(Constant.STATUS)==0){
				IOUtils.mySnackBar(mContext, Message, (LinearLayout)activity.findViewById(R.id.rootView));
				return null;
			}else if(jsonObject.getInt(Constant.STATUS)==1){

				//--- HEADER IMAGE------//
				JSONArray jaHeaderImg=jsonObject.getJSONArray(Constant.HOME_HEADERIMAGE);
				if(jaHeaderImg.length()>0){
					for(int i=0;i<jaHeaderImg.length();i++){
						JSONObject joInner = jaHeaderImg.getJSONObject(i);
						ModelHeaderImage recordHeaderImage=new ModelHeaderImage();

						if(!joInner.isNull(Constant.HOME_ID))
							recordHeaderImage.setId(joInner.getString(Constant.HOME_ID));
						if(!joInner.isNull(Constant.HOME_TITLE))
							recordHeaderImage.setTitle(joInner.getString(Constant.HOME_TITLE));
						if(!joInner.isNull(Constant.HOME_IMAGEURL))
							recordHeaderImage.setImageUrl(joInner.getString(Constant.HOME_IMAGEURL));
						if(!joInner.isNull(Constant.HOME_TYPE))
							recordHeaderImage.setType(joInner.getString(Constant.HOME_TYPE));
						if(!joInner.isNull(Constant.HOME_ELEMENTID))
							recordHeaderImage.setElementId(joInner.getString(Constant.HOME_ELEMENTID));

						arrayListHeaderImage.add(recordHeaderImage);
						modelHome.setModelHeaderImage(arrayListHeaderImage);
					}
				}

				//------ BANNERS ----//
				JSONArray jaBanners=jsonObject.getJSONArray(Constant.HOME_BANNERS);
				if(jaBanners.length()>0){
					for(int i=0;i<jaBanners.length();i++){
						JSONObject joInner = jaBanners.getJSONObject(i);
						ModelBanners recordBanners=new ModelBanners();
						if(!joInner.isNull(Constant.HOME_ID))
							recordBanners.setId(joInner.getString(Constant.HOME_ID));
						if(!joInner.isNull(Constant.HOME_TITLE))
							recordBanners.setTitle(joInner.getString(Constant.HOME_TITLE));
						if(!joInner.isNull(Constant.HOME_IMAGEURL))
							recordBanners.setImageUrl(joInner.getString(Constant.HOME_IMAGEURL));
						if(!joInner.isNull(Constant.HOME_TYPE))
							recordBanners.setType(joInner.getString(Constant.HOME_TYPE));
						if(!joInner.isNull(Constant.HOME_ELEMENTID))
							recordBanners.setElementId(joInner.getString(Constant.HOME_ELEMENTID));

						arrayListBanners.add(recordBanners);
						modelHome.setModelBanners(arrayListBanners);
					}
				}

				//----- HOMEPAGEBLOCKS -----//

				JSONObject jobjInner = jsonObject.getJSONObject(Constant.HOME_HOMEPAGEBLOCKS);
				if(!jobjInner.isNull(Constant.HOME_HEADER))
					modelHomepageBlocks.setHeader(jobjInner.getString(Constant.HOME_HEADER));

				JSONArray jaContent=jobjInner.getJSONArray(Constant.HOME_CONTENT);
				if(jaContent.length()>0){
					for(int i=0;i<jaContent.length();i++){
						JSONObject joInner = jaContent.getJSONObject(i);
						ModelBanners recordContent=new ModelBanners();
						if(!joInner.isNull(Constant.HOME_ID))
							recordContent.setId(joInner.getString(Constant.HOME_ID));
						if(!joInner.isNull(Constant.HOME_TITLE))
							recordContent.setTitle(joInner.getString(Constant.HOME_TITLE));
						if(!joInner.isNull(Constant.HOME_IMAGEURL))
							recordContent.setImageUrl(joInner.getString(Constant.HOME_IMAGEURL));
						if(!joInner.isNull(Constant.HOME_TYPE))
							recordContent.setType(joInner.getString(Constant.HOME_TYPE));
						if(!joInner.isNull(Constant.HOME_ELEMENTID))
							recordContent.setElementId(joInner.getString(Constant.HOME_ELEMENTID));

						arrayListContent.add(recordContent);
						modelHomepageBlocks.setModelBanners(arrayListContent);
						modelHome.setModelHomepageBlocks(modelHomepageBlocks);

					}
				}
				//------ PROMOTIONS ------//

				JSONArray jaPromotions=jsonObject.getJSONArray(Constant.HOME_PROMOTIONS);
				if(jaPromotions.length()>0){
					for(int i=0;i<jaPromotions.length();i++){
						JSONObject joInner = jaPromotions.getJSONObject(i);

						if(!joInner.isNull(Constant.HOME_ID))
							recordPromotions.setId(joInner.getString(Constant.HOME_ID));
						if(!joInner.isNull(Constant.HOME_TITLE))
							recordPromotions.setTitle(joInner.getString(Constant.HOME_TITLE));
						if(!joInner.isNull(Constant.HOME_TYPE))
							recordPromotions.setType(joInner.getString(Constant.HOME_TYPE));
						if(!joInner.isNull(Constant.HOME_LINK))
							recordPromotions.setLink(joInner.getString(Constant.HOME_LINK));

						JSONArray jaProducts=joInner.getJSONArray(Constant.HOME_PRODUCTS);
						if(jaProducts.length()>0){
							for(int j=0;j<jaProducts.length();j++){

								JSONObject joInnerPro = jaProducts.getJSONObject(j);
								ModelProduct modelProduct = new ModelProduct();
								ModelPrice modelPrice = new ModelPrice();
								if(!joInnerPro.isNull(Constant.HOME_ID))
									modelProduct.setId(Integer.valueOf(joInnerPro.getString(Constant.HOME_ID)));
								if(!joInnerPro.isNull(Constant.PRODUCT_NAME))
									modelProduct.setProductName(joInnerPro.getString(Constant.PRODUCT_NAME));
								if(!joInnerPro.isNull(Constant.CURRENCY))
									modelProduct.setCurrency(joInnerPro.getString(Constant.CURRENCY));

								JSONObject joInnerPrice =joInnerPro.getJSONObject(Constant.PRODUCT_PRICE);
								if(!joInnerPrice.isNull(Constant.PRODUCT_PRICE))
									modelPrice.setPrice(joInnerPrice.getString(Constant.PRODUCT_PRICE));
								if(!joInnerPrice.isNull(Constant.PRODUCT_SPECIALPRICE))
									modelPrice.setSpecialPrice(joInnerPrice.getString(Constant.PRODUCT_SPECIALPRICE));

								modelProduct.setModelPrice(modelPrice);

								if(!joInnerPro.isNull(Constant.PRODUCT_IMAGE_URL)) {
									JSONArray arrayOfImages=joInnerPro.getJSONArray(Constant.PRODUCT_IMAGE_URL);
									modelProduct.setImageUrl(arrayOfImages.getString(0));
								}
								arrayListProduct.add(modelProduct);
								recordPromotions.setModelProduct(arrayListProduct);
							}
						}

						arrayListPromotions.add(recordPromotions);
						modelHome.setModelPromotions(arrayListPromotions);

					}
				}

				//---- STORES ----//

				JSONObject jobjectInner = jsonObject.getJSONObject(Constant.HOME_STORES);
				if(!jobjectInner.isNull(Constant.HOME_HEADER))
					modelStores.setHeader(jobjectInner.getString(Constant.HOME_HEADER));
				if(!jobjectInner.isNull(Constant.HOME_IMAGEURL))
					modelStores.setImageUrl(jobjectInner.getString(Constant.HOME_IMAGEURL));

				modelHome.setModelStores(modelStores);



				//-------- CATEGORY ------//
				JSONArray jaCategory=jsonObject.getJSONArray(Constant.HOME_CATEGORY);
				if(jaCategory.length()>0){
					for(int i=0;i<jaCategory.length();i++){
						JSONObject joInner = jaCategory.getJSONObject(i);
						ModelCategory recordCategory=new ModelCategory();

						if(!joInner.isNull(Constant.HOME_ID))
							recordCategory.setId(joInner.getString(Constant.HOME_ID));
						if(!joInner.isNull(Constant.HOME_NAME))
							recordCategory.setName(joInner.getString(Constant.HOME_NAME));

						arrayListCategory.add(recordCategory);
						modelHome.setModelCategory(arrayListCategory);
					}
				}
			}

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return modelHome;
	}


	



}





/*String CartItemId=joInner.getString(Constant.CART_CARTITEMID);
					String ProductId=joInner.getString(Constant.CART_PRODUCTID);
					String ProductImage=joInner.getString(Constant.CART_PRODUCTIMAGE);
					String ProductMaxQty=joInner.getString(Constant.CART_PRODUCTMAXQTY);
					String ProductName=joInner.getString(Constant.CART_PRODUCTNAME);
					String ProductPrice=joInner.getString(Constant.CART_PRODUCTPRICE);
					String ProductQty=joInner.getString(Constant.CART_PRODUCTMAXQTY);*/

package com.lola.services.util;

import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.lola.dao.BrandDealsandOffersDao;
import com.lola.dao.BrandDealsandOffersDaoImpl;
import com.lola.dao.BrandImagesDataDao;
import com.lola.dao.BrandImagesDataDaoImpl;
import com.lola.dao.BrandMySpecialsDao;
import com.lola.dao.BrandMySpecialsDaoImpl;
import com.lola.dao.BrandNewArrivalsDao;
import com.lola.dao.BrandNewArrivalsDaoImpl;
import com.lola.dao.BrandPhotoImagesDao;
import com.lola.dao.BrandPhotoImagesDaoImpl;
import com.lola.model.BrandChildPhotoImages;
import com.lola.model.BrandDealsandOffers;
import com.lola.model.BrandImageData;
import com.lola.model.BrandNewArrivals;
import com.lola.model.MySpecialsChild;

public class SearchUtility {

	@SuppressWarnings("rawtypes")
	BrandImagesDataDao brandImagesDataDaoImpl = new BrandImagesDataDaoImpl();
	@SuppressWarnings("rawtypes")
	BrandNewArrivalsDao brandNewArrivalsDaoImpl = new BrandNewArrivalsDaoImpl();
	@SuppressWarnings("rawtypes")
	BrandDealsandOffersDao brandDealsandOffersDaoImpl = new BrandDealsandOffersDaoImpl();
	@SuppressWarnings("rawtypes")
	BrandMySpecialsDao brandMySpecialsDaoImpl = new BrandMySpecialsDaoImpl();
	@SuppressWarnings("rawtypes")
	BrandPhotoImagesDao brandPhotoImagesDaoImpl = new BrandPhotoImagesDaoImpl();

	@SuppressWarnings("unchecked")
	public String searchBucketsAcrossBrands(int userid, String searchString)
			throws Exception {
		String path1 = null;
		JSONObject parentObject = new JSONObject();

		try {

			List<BrandImageData> brands = brandImagesDataDaoImpl.getAllBrands(
					userid, searchString);
			List<BrandImageData> myBrands = brandImagesDataDaoImpl.getMyBrands(
					userid, searchString);
			List<BrandNewArrivals> brandNewArrivals = brandNewArrivalsDaoImpl
					.findAllNewArrivals(searchString);
			List<BrandDealsandOffers> brandDealsandOffers = brandDealsandOffersDaoImpl
					.findAllBrandDealsandOffers(searchString);
			List<MySpecialsChild> mySpecialChild = brandMySpecialsDaoImpl
					.findAllMySpecialChild(searchString);
			List<BrandChildPhotoImages> brandChildPhotoImages = brandPhotoImagesDaoImpl
					.findAllPhotoImages(searchString);
			/*if (brands.size() != 0 || myBrands.size() != 0
					|| brandNewArrivals.size() != 0
					|| brandDealsandOffers.size() != 0
					|| mySpecialChild.size() != 0
					|| brandChildPhotoImages.size() != 0) {
*/
				if (brands.size() > 0) {
					JSONArray brandsArray = new JSONArray();
					JSONObject brandsObject = null;

					for (BrandImageData i : brands) {
						brandsObject = new JSONObject();
						brandsObject.put("Status", "Success");
						brandsObject.put("brandId", i.getBrandId());
						brandsObject.put("brandName", i.getBrandName());
						path1 = LolaConstants.url + i.getBrandimage();
						brandsObject.put("imagepath", path1);

						brandsArray.put(brandsObject);
					}
					
					parentObject.put("allbrands", brandsArray);
				}else{
					JSONObject brandsObject = null;
					brandsObject = new JSONObject();
					JSONArray brandsArray = new JSONArray();
					brandsObject.put("Status", "Failure");
					brandsArray.put(brandsObject);
					parentObject.put("allbrands", brandsArray);
					
				}

				if (myBrands.size() > 0) {
					JSONArray myBrandsArray = new JSONArray();
					JSONObject myBrandsObject = null;

					for (BrandImageData i : myBrands) {
						myBrandsObject = new JSONObject();
						myBrandsObject.put("Status", "Success");
						myBrandsObject.put("brandId", i.getBrandId());
						myBrandsObject.put("brandName", i.getBrandName());
						path1 = LolaConstants.url + i.getBrandimage();
						myBrandsObject.put("imagepath", path1);

						myBrandsArray.put(myBrandsObject);
					}
					parentObject.put("mybrands", myBrandsArray);
				}else{
					JSONObject myBrandsObject = null;
					myBrandsObject = new JSONObject();
					JSONArray myBrandsArray = new JSONArray();
					myBrandsObject.put("Status", "Failure");
					myBrandsArray.put(myBrandsObject);
					parentObject.put("mybrands", myBrandsArray);
				}

				if (brandNewArrivals.size() > 0) {
					JSONArray newArrivalArray = new JSONArray();
					JSONObject newArrivalObject = null;

					for (BrandNewArrivals i : brandNewArrivals) {
						newArrivalObject = new JSONObject();
						newArrivalObject.put("Status", "Success");
						newArrivalObject.put("brandId", i.getBrandId());
						newArrivalObject.put("newarrivalId",
								i.getNewarrivalId());
						path1 = LolaConstants.url + i.getArrivalImage();
						newArrivalObject.put("imagepath", path1);
						newArrivalObject.put("desc", i.getNewarrivaldesc());
						newArrivalObject.put("content", i.getContent());
						// newArrivalObject.put("like",i.isLiked());
						// System.out.println(i.getBrandId()+"   "+i.getNewarrivalId()+"   "+i.getArrivalImage()+"    "+i.getNewarrivaldesc()+"   "+i.getContent()+"    "+i.isLiked());
						newArrivalArray.put(newArrivalObject);
					}
					parentObject.put("newarrivals", newArrivalArray);
				}else{
					JSONObject newArrivalObject = null;
					newArrivalObject = new JSONObject();
					JSONArray newArrivalArray = new JSONArray();
					newArrivalObject.put("Status", "Failure");
					newArrivalArray.put(newArrivalObject);
					parentObject.put("newarrivals", newArrivalArray);
				}

				if (brandDealsandOffers.size() > 0) {
					JSONArray dealsnOffersArray = new JSONArray();
					JSONObject dealsnOffersObject = null;

					for (BrandDealsandOffers i : brandDealsandOffers) {
						dealsnOffersObject = new JSONObject();
						dealsnOffersObject.put("Status", "Success");
						dealsnOffersObject.put("brandId", i.getBrandId());
						dealsnOffersObject.put("dealandofferId",
								i.getDealandofferId());
						path1 = LolaConstants.url + i.getOfferImage();
						dealsnOffersObject.put("imagepath", path1);
						dealsnOffersObject.put("desc", i.getDealDesc());
						dealsnOffersObject.put("content", i.getContent());
						// dealsnOffersObject.put("like",i.isLiked());
						// System.out.println(i.getBrandId()+"   "+i.getDealandofferId()+"   "+i.getOfferImage()+"    "+i.getDealDesc()+"   "+i.getContent()+"    "+i.isLiked());
						dealsnOffersArray.put(dealsnOffersObject);
					}
					parentObject.put("dealsnoffers", dealsnOffersArray);
				}else{
					JSONObject dealsnOffersObject = null;
					dealsnOffersObject = new JSONObject();
					JSONArray dealsnOffersArray = new JSONArray();
					dealsnOffersObject.put("Status", "Failure");
					dealsnOffersArray.put(dealsnOffersObject);
					parentObject.put("dealsnoffers", dealsnOffersArray);
				}

				if (mySpecialChild.size() > 0) {
					JSONArray mySpecialChildArray = new JSONArray();
					JSONObject mySpecialChildObject = null;

					for (MySpecialsChild i : mySpecialChild) {
						mySpecialChildObject = new JSONObject();
						mySpecialChildObject.put("Status", "Success");
						mySpecialChildObject.put("brandId", i.getBrandId());
						mySpecialChildObject.put("brandspecialId",
								i.getBrandspecialid());
						mySpecialChildObject.put("myspecialchildId",
								i.getMyspecialchildId());
						path1 = LolaConstants.url + i.getChildimagepath();
						mySpecialChildObject.put("imagepath", path1);
						mySpecialChildObject.put("desc", i.getSpecialDesc());
						mySpecialChildObject.put("content", i.getContent());
						// mySpecialChildObject.put("like",i.isLiked());
						// System.out.println(i.getBrandId()+"   "+i.getBrandspecialid()+"   "+i.getMyspecialchildId()+"   "+i.getChildimagepath()+"   "+i.getSpecialDesc()+"    "+i.getContent());
						mySpecialChildArray.put(mySpecialChildObject);
					}
					parentObject.put("myspecialchild", mySpecialChildArray);
				}else{
					JSONObject mySpecialChildObject = null;
					mySpecialChildObject = new JSONObject();
					JSONArray mySpecialChildArray = new JSONArray();
					mySpecialChildObject.put("Status", "Failure");
					mySpecialChildArray.put(mySpecialChildObject);
					parentObject.put("myspecialchild", mySpecialChildArray);
				}

				if (brandChildPhotoImages.size() > 0) {
					JSONArray brandChildPhotoImagesArray = new JSONArray();
					JSONObject brandChildPhotoImagesObject = null;

					for (BrandChildPhotoImages i : brandChildPhotoImages) {
						brandChildPhotoImagesObject = new JSONObject();
						brandChildPhotoImagesObject.put("Status", "Success");
						brandChildPhotoImagesObject.put("brandId",
								i.getBrandId());
						brandChildPhotoImagesObject.put("photoId",
								i.getPhotoId());
						brandChildPhotoImagesObject.put("childphotoimageid",
								i.getChildphotoimageId());
						path1 = LolaConstants.url + i.getImagepath();
						brandChildPhotoImagesObject.put("imagepath", path1);
						brandChildPhotoImagesObject.put("desc",
								i.getPhotoDesc());
						brandChildPhotoImagesObject.put("content",
								i.getContent());
						// brandChildPhotoImagesObject.put("like",i.isLiked());
						// System.out.println(i.getPhotoId()+"    "+i.getChildphotoimageId()+"    "+i.getImagepath()+"    "+i.isLiked()+"     "+i.getPhotoDesc()+"    "+i.getContent()+"    "+i.getBrandId());
						brandChildPhotoImagesArray
								.put(brandChildPhotoImagesObject);
					}
					parentObject.put("brandchildphotoimages",
							brandChildPhotoImagesArray);
				}else{
					JSONObject brandChildPhotoImagesObject = null;
					brandChildPhotoImagesObject = new JSONObject();
					JSONArray brandChildPhotoImagesArray = new JSONArray();
					brandChildPhotoImagesObject.put("Status", "Failure");
					brandChildPhotoImagesArray.put(brandChildPhotoImagesObject);
					parentObject.put("brandchildphotoimages", brandChildPhotoImagesArray);
				}
				//parentObject.put("Status", "Success");
				//parentObject.put("Message", "Search result fetch success");
			/*} else {
				parentObject.put("Status", "Failure");
				parentObject.put("Message", "no Search result fetch ");
			}*/
		} catch (Exception exception) {
			parentObject.put("Status", "Failure");
			parentObject.put("Message", "Search result fetch Failed");

			return parentObject.toString().replace("\\", "");

		}

		return parentObject.toString().replace("\\", "");

	}

	public static void main(String args[]) throws Exception {
		SearchUtility searchUtility = new SearchUtility();
		System.out.println(searchUtility
				.searchBucketsAcrossBrands(1, ""));
	}

}

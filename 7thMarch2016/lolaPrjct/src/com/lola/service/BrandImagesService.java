package com.lola.service;

public interface BrandImagesService {
	public String findByCategoryIdWithLimit(int categoryId, int start,
			int offset) throws Exception;

}

package com.tealium.datacloud.distribute.facebook.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import com.google.common.base.Objects;
import com.tealium.datacloud.distribute.google.actions.rest.oauth2.model.GoogleOAuth2AccessTokenResponse;
import com.tealium.datacloud.distribute.google.actions.rest.oauth2.model.GoogleOAuth2ServiceAuth;
import com.tealium.datacloud.distribute.resources.VendorConstants;
import com.tealium.datacloud.distribute.util.VendorStringUtil;
import com.tealium.datacloud.distribute.vendor.model.cache.VendorCache;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacebookAuthCacheOAuth2 extends VendorCache {

	private FacebookOAuth2AccessTokenResponse cachedAuth;

	public FacebookOAuth2AccessTokenResponse getCachedAuth() {
		return cachedAuth;
	}

	public void setCachedAuth(FacebookOAuth2AccessTokenResponse cachedAuth) {
		this.cachedAuth = cachedAuth;
	}

	public static String constructVendorAuthCacheKey(FacebookOAuth2ServiceAuth vendorAuth) {
		return (VendorStringUtil.buildStringParamsWithStringBuilderAddSplitChar(VendorConstants.CHAR_DOT, vendorAuth.getClientId(),
				vendorAuth.getClientSecret(), vendorAuth.getRefreshToken()));
	}

	@Override
	public String toString() {
		//@formatter:off
		return Objects.toStringHelper(this)
			.add("super", super.toString())
			.add("cachedAuth", cachedAuth)
			.toString();
		//@formatter:on
	}

}
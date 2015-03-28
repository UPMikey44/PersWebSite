package com.tealium.datacloud.distribute.facebook.actions.rest;

import java.util.Map;

import javax.validation.Validator;

import com.tealium.datacloud.distribute.resources.SalesforceConstants;
import com.tealium.datacloud.distribute.resources.VendorConstants.HttpRequestMethod;
import com.tealium.datacloud.distribute.salesforce.SalesforceRestClient;
import com.tealium.datacloud.distribute.salesforce.model.SalesforceServiceAuth;
import com.tealium.datacloud.distribute.salesforce.model.SalesforceVendorSDKAction;
import com.tealium.datacloud.distribute.salesforce.validation.groups.GroupSalesGetApiAccessToken;
import com.tealium.datacloud.distribute.util.JsonUtil;
import com.tealium.datacloud.distribute.vendor.AbstractVendorActionClient;
import com.tealium.datacloud.distribute.vendor.VendorActionClient;
import com.tealium.datacloud.distribute.vendor.exception.VendorApiException;
import com.tealium.datacloud.distribute.vendor.model.ActionResultTypeFormat;
import com.tealium.datacloud.distribute.vendor.model.ApiCallResult;

public class FacebookOAuth2RestClient implements VendorActionClient<String, SalesforceServiceAuth> {

	protected FacebookServiceConfig vendorConfig;

	public static final Class<?>[] VALIDATION_GROUPS_AUTH_OAUTH2 = { GroupFacebookAuthOAuth2.class };

	public FacebookOAuth2RestClient(Validator validator) {
		super(validator);
	}

	public FacebookOAuth2RestClient(FacebookServiceConfig vendorConfig, Validator validator) {
		super(validator);
		this.vendorConfig = vendorConfig;
	}

	public static boolean isExpiredAuthCacheOAuth2(FacebookAuthCacheOAuth2 authCacheValue) {
		if (authCacheValue == null || authCacheValue.getCachedAuth() == null) {
			return true;
		} else {
			FacebookOAuth2AccessTokenResponse authCache = authCacheValue.getCachedAuth();
			if (authCache != null) {
				if (System.currentTimeMillis() >= authCache.getExpirationTimeMiliSeconds()) {
					return true;
				} else {
					return false;
				}
			}
			return true;
		}
	}

	public static FacebookOAuth2AccessTokenResponse loginOAuth2(FacebookOAuth2ServiceAuth vendorAuth, Validator validator) throws Exception {
		FacebookOAuth2ActionRestGetApiAccessToken FacebookActionRestGetApiAccessToken = new FacebookOAuth2ActionRestGetApiAccessToken(validator);
		FacebookOAuth2AccessTokenResponse response = FacebookActionRestGetApiAccessToken.executeAction(vendorAuth);
		if (response == null || Strings.isNullOrEmpty(response.getAccessToken())) {
			throw new VendorApiException("OAuth2 login failed, empty/null http reponse");
		}
		return response;
	}

	@Override
	public ApiCallResult isResponseError(Object responseMsg, FacebookRestOperationType responseType) throws Exception {
		String status = "";
		boolean valid = true;
		Object results = responseMsg;

		if (responseMsg == null) {
			throw new RuntimeException("Empty response");
		}

		switch (responseType) {
			case OAUTH2_ACCESS_TOKEN: {
				FacebookOAuth2AccessTokenResponse result = (FacebookOAuth2AccessTokenResponse) responseMsg;
				if (!Strings.isNullOrEmpty(result.getAccessToken())) {
					status = "OK";
					valid = true;
				} else {
					status = "ERROR";
					valid = false;
				}
				break;
			}
			case OAUTH2_REFRESH_TOKEN: {
				FacebookOAuth2RefreshTokenResponse result = (FacebookOAuth2RefreshTokenResponse) responseMsg;
				if (!Strings.isNullOrEmpty(result.getRefreshToken())) {
					status = "OK";
					valid = true;
				} else {
					status = "ERROR";
					valid = false;
				}
				break;
			}
			default:
				valid = false;
				status = "UNKONWN RESPONSE";
				break;
		}

		return new ApiCallResult(valid, status, results);
	}


}
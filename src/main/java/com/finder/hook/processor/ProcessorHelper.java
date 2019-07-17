package com.finder.hook.processor;

import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.okhttp.OkHttpClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
/**
 * @author theinlwin
 * @createdAt 7/10/2019
 */

@SuppressWarnings("unused")
public class ProcessorHelper {

	private final static Logger logger = LoggerFactory
			.getLogger(ProcessorHelper.class);

	@SuppressWarnings("null")
	public static OkHttpClient configureClient(final OkHttpClient client) {
		final TrustManager[] certs = new TrustManager[] { new X509TrustManager() {

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkServerTrusted(final X509Certificate[] chain,
					final String authType) throws CertificateException {
			}

			@Override
			public void checkClientTrusted(final X509Certificate[] chain,
					final String authType) throws CertificateException {
			}
		} };

		SSLContext ctx = null;
		try {
			ctx = SSLContext.getInstance("TLS");
			ctx.init(null, certs, new SecureRandom());
		} catch (final java.security.GeneralSecurityException ex) {
		}

		try {
			final HostnameVerifier hostnameVerifier = new HostnameVerifier() {
				@Override
				public boolean verify(final String hostname,
						final SSLSession session) {
					return true;
				}
			};
			client.setHostnameVerifier(hostnameVerifier);
			client.setSslSocketFactory(ctx.getSocketFactory());
		} catch (final Exception e) {
		}

		return client;
	}

	public static OkHttpClient createClient() {
		final OkHttpClient client = new OkHttpClient();
		return configureClient(client);
	}

	@SuppressWarnings("rawtypes")
	public static Callback createCallback(final String url) {
		return new Callback() {
			@Override
			public void onFailure(Call call, Throwable t) {
				logger.info(t.getMessage());
			}
			@Override
			public void onResponse(Call call, Response response) {
				logger.info("URL : " + url + "\tStatus : "+ response.body());
			}
		};
	}

	public static WebHookService createWebHookService(final String url) {
		final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url) // On AVD
                .addConverterFactory(GsonConverterFactory.create())
                .build();
		return retrofit.create(WebHookService.class);
		
//		final OkHttpClient client = ProcessorHelper.createClient();
//		final Retrofit restAdapter = new Retrofit.Builder().baseUrl(url).build();
//		return restAdapter.create(WebHookService.class);
	}

}
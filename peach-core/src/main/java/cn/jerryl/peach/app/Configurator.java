package cn.jerryl.peach.app;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.util.HashMap;

import cn.jerryl.peach.util.log.PeachLogger;


/**
 * Created by Jerry
 */

public final class Configurator {

	private static final HashMap<Object, Object> PEACH_CONFIGS = new HashMap<>();
//    private static final Handler HANDLER = new Handler();

	private Configurator() {
		PEACH_CONFIGS.put(ConfigKeys.CONFIG_READY, false);
//        PEACH_CONFIGS.put(ConfigKeys.HANDLER, HANDLER);
	}

	static Configurator getInstance() {
		return Holder.INSTANCE;
	}

	final HashMap<Object, Object> getPeachConfigs() {
		return PEACH_CONFIGS;
	}

	private static class Holder {
		private static final Configurator INSTANCE = new Configurator();
	}

	public final void configure() {
		initLogger();
		PEACH_CONFIGS.put(ConfigKeys.CONFIG_READY, true);
	}

	/**
	 * 初始化 logger 工具
	 */
	private void initLogger() {
		// 启动 logger
		FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
				.tag(PeachLogger.LOGGER_TAG)
				.build();
		Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

		// 禁用 logger
//		Logger.addLogAdapter(new AndroidLogAdapter(){
//			@Override
//			public boolean isLoggable(int priority, String tag) {
//				return BuildConfig.DEBUG;
//			}
//		});
	}

	public final Configurator withApiHost(String host) {
		PEACH_CONFIGS.put(ConfigKeys.API_HOST, host);
		return this;
	}

	public final Configurator withLoaderDelayed(long delayed) {
		PEACH_CONFIGS.put(ConfigKeys.LOADER_DELAYED, delayed);
		return this;
	}

	public final Configurator withWeChatAppId(String appId) {
		PEACH_CONFIGS.put(ConfigKeys.WE_CHAT_APP_ID, appId);
		return this;
	}

	public final Configurator withWeChatAppSecret(String appSecret) {
		PEACH_CONFIGS.put(ConfigKeys.WE_CHAT_APP_SECRET, appSecret);
		return this;
	}

	public final Configurator withActivity(Activity activity) {
		PEACH_CONFIGS.put(ConfigKeys.ACTIVITY, activity);
		return this;
	}

	public Configurator withJavascriptInterface(@NonNull String name) {
		PEACH_CONFIGS.put(ConfigKeys.JAVASCRIPT_INTERFACE, name);
		return this;
	}


	private void checkConfiguration() {
		final boolean isReady = (boolean) PEACH_CONFIGS.get(ConfigKeys.CONFIG_READY);
		if (!isReady) {
			throw new RuntimeException("Configuration is not ready,call configure");
		}
	}

	@SuppressWarnings("unchecked")
	final <T> T getConfiguration(Object key) {
		checkConfiguration();
		final Object value = PEACH_CONFIGS.get(key);
		if (value == null) {
			throw new NullPointerException(key.toString() + " IS NULL");
		}
		return (T) PEACH_CONFIGS.get(key);
	}
}

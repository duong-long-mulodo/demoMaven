package com.mulodo.freemarket.activity;

import java.util.Iterator;
import java.util.Stack;
import android.app.Activity;
import android.content.Intent;

/**
 * Common Activity Manager to manage all running activity
 * 
 * @author laihuythinh
 */
public class CommonActivityManager {
	private static CommonActivityManager activityStack = null;
	private Stack<Activity> stack = null;
	public Stack<Intent> stackIntent = null;

	/**
	 * Get Instance CommonActivityManager
	 * 
	 * @return
	 */
	public static CommonActivityManager getInstance() {
		if (activityStack == null) {
			// Init new CommonActivityManager
			activityStack = new CommonActivityManager();
		}
		return activityStack;
	}

	/**
	 * Init new
	 */
	private CommonActivityManager() {
		stack = new Stack<Activity>();
		stackIntent = new Stack<Intent>();
	}

	/**
	 * Push new activity to stack
	 * 
	 * @param activity
	 */
	public void push(Activity activity) {
		removeIsFinishingActivity();
		stack.push(activity);
	}

	/**
	 * Push new intent to stack
	 * 
	 * @param intent
	 */
	public void pushIntent(Intent intent) {
		Iterator<Intent> it = stackIntent.listIterator();
		while (it.hasNext()) {
			Intent i = it.next();
			if (i != null && i.getComponent().equals(intent.getComponent())) {
				it.remove();
			}
		}
		stackIntent.push(intent);
	}

	/**
	 * Pop new intent to stack
	 * 
	 * @param intent
	 */
	public Intent popIntent() {
		if (stackIntent != null && !stackIntent.empty()) {
			return stackIntent.pop();
		}
		return null;
	}

	/**
	 * Check empty stackIntent
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (stackIntent != null && !stackIntent.empty()) {
			return stackIntent.empty();
		}
		return true;
	}

	/**
	 * Clear stackIntent
	 */
	public void clearIntent() {
		if (stackIntent != null) {
			stackIntent.clear();
		}
	}

	/**
	 * Finish all activity
	 */
	public void finishAll() {
		for (Activity activity : stack) {
			if (activity != null && !activity.isFinishing()) {
				activity.finish();
			}
		}
		destory();
	}

	/**
	 * Clear stack
	 */
	public void clear() {
		if (stack != null) {
			stack.clear();
		}
	}

	/**
	 * Clear activity stack
	 */
	private void destory() {
		activityStack.clear();
		activityStack = null;
	}

	/**
	 * Check and remove activity if it fisnish
	 */
	private void removeIsFinishingActivity() {
		Iterator<Activity> itr = stack.iterator();
		while (itr.hasNext()) {
			Activity act = itr.next();
			if (act == null || act.isFinishing()) {
				itr.remove();
			}
		}
	}
}

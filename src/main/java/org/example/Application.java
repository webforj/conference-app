package org.example;

import com.webforj.App;
import com.webforj.annotation.AppProfile;
import com.webforj.annotation.AppTheme;
import com.webforj.annotation.AppTitle;
import com.webforj.annotation.Routify;
import com.webforj.annotation.StyleSheet;

@Routify(packages = "org.example.views")
@StyleSheet("ws://styles/app.css")
@StyleSheet("ws://styles/typography.css")
@AppTitle("My App")
// @AppTheme("system")
@AppProfile(name = "My App", shortName = "My App")
public class Application extends App {
}

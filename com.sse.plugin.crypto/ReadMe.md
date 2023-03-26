## Steps to be done in Creating Eclipse Plugin


1. Create a new plugin-development project.
2. Add dependencies ```org.eclipse.core.runtime```, ```org.eclipse.ui``` in plugin.xml file.
3. Add extensions ```org.eclipse.ui.views``` in plugin.xml
4. Add extension points  ```org.eclipse.ui.menus``` in plugin.xml for creating menu/toolbar 
5. Add a new menu configuration under menu by clicking new -> menu contribution in menu
6. In the location uri add ```toolbar:<-identifier-of-your-view-where-you-want-your-toolbar->```
7. Add a command extension and add a new command in it, here I named the command EncryptCommand.
8. Add a handler extension, as every command needs an handler and add the commandId in the handler extension.
9. Type in a class name of your choice for the handler.
10. Then by clicking the hyperlink class, your new class will be created, inheriting the AbstractHandler class.
11. After successful creation of handler, attach this handler to default handler of your command

In this project I created two views, ```com.sse.plugin.crypto.CryptoPlugin.java``` and ```com.sse.plugin.crypto.View.java```.
The default view will be CryptoPlugin View and the toolbar is located there.


## Run the plugin

Run the plugin as an eclipse application. It will create a new eclipse runtime environment. Select ```Window-> Show View -> Other -> Other-> CryptoPlugin```
There you can see the Toolbar with the text "Encrypt". When you press the toolbar, the new View will be attached which has the textfield and the button.
Type text in the text-field and click the button, the text in the text-field will be encrypted.
The algorithm used for encryption is a Signature class from javax.crypto.
There is no specific reason in selecting this cryptographic algorithm.
Click the toolbar, it will attach another view with textview and button.
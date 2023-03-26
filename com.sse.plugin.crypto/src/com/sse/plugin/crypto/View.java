package com.sse.plugin.crypto;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.Cipher;

public class View extends ViewPart {

	public View() {
	}

	@Override
	public void createPartControl(Composite parent) {

		Text text = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		
		Button button = new Button(parent, SWT.PUSH);
		button.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		button.setText("encrypt");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String input = text.getText();
		        String ciphertext;
				try {
					ciphertext = encrypt(input.getBytes());
					text.setText(ciphertext);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	
	private String encrypt(byte[] input) throws Exception {
		
	      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
	      keyPairGen.initialize(2048);
	      KeyPair pair = keyPairGen.generateKeyPair();  
	      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
	      cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
	      cipher.update(input);
		  byte[] cipherText = cipher.doFinal();
	      
	      
		return cipherText.toString();
	}
	
	

	@Override
	public void setFocus() {

	}

}

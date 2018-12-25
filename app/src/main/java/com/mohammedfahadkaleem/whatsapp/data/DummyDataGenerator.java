package com.mohammedfahadkaleem.whatsapp.data;

import android.content.Context;
import android.content.res.TypedArray;
import com.mohammedfahadkaleem.whatsapp.R;
import com.mohammedfahadkaleem.whatsapp.model.User;
import com.mohammedfahadkaleem.whatsapp.model.Message;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@SuppressWarnings("ResourceType")
public class DummyDataGenerator {

    public static List<User> getContactsData(Context ctx) {
        List<User> items = new ArrayList<>();
        TypedArray photosArray = ctx.getResources().obtainTypedArray(R.array.contact_images);
        TypedArray readReceiptsArray = ctx.getResources().obtainTypedArray(R.array.read_receipts);
        TypedArray callIndicatorArray = ctx.getResources().obtainTypedArray(R.array.call_indicator);
        String namesArray[] = ctx.getResources().getStringArray(R.array.contact_names);
        String messagesArray[] = ctx.getResources().getStringArray(R.array.contact_messages);

        for (int i = 0; i < photosArray.length(); i++) {
            User contact = new User();
            contact.image = photosArray.getResourceId(i, -1);
            contact.readReceipt = readReceiptsArray.getResourceId(new Random().nextInt(3),-1);
            contact.callIndicator = callIndicatorArray.getResourceId(new Random().nextInt(3),-1);
            contact.name = namesArray[i];
            contact.email = "+91984910345";
            contact.imageDrw = ctx.getResources().getDrawable(contact.image);
            contact.readReceiptDrw = ctx.getResources().getDrawable(contact.readReceipt);
            contact.callIndicatorDrw = ctx.getResources().getDrawable(contact.callIndicator);
            contact.message = messagesArray[i];
            contact.status = "This is a dummy status";
            contact.contactType = "MOBILE";
            items.add(contact);
        }
        Collections.shuffle(items);
        photosArray.recycle();
        return items;
    }

    public static List<Message> getMessageData(Context ctx){
        List<Message> messagesList = new ArrayList<>();
        String messagesArray[] = ctx.getResources().getStringArray(R.array.jon_snow_chat);
        for(int i=0;i<messagesArray.length;i++){
            Message message = new Message();
            message.setData(messagesArray[i]);
            messagesList.add(message);
        }
        return messagesList;
    }

    public static List<User> getContactsListData(Context ctx) {
        List<User> contacts = new ArrayList<>();
        TypedArray photosArray = ctx.getResources().obtainTypedArray(R.array.contact_images);
        String namesArray[] = ctx.getResources().getStringArray(R.array.contact_names);
        String messagesArray[] = ctx.getResources().getStringArray(R.array.contact_messages);

        for (int i = 0; i < photosArray.length(); i++) {
            User contact = new User();
            contact.image = photosArray.getResourceId(i, -1);
            contact.name = namesArray[i];
            contact.imageDrw = ctx.getResources().getDrawable(contact.image);
            contact.status = "This is a dummy status";
            contact.contactType = "MOBILE";
            contacts.add(contact);
        }
        Collections.sort(contacts,User.ContactsNameComparator);
        photosArray.recycle();
        return contacts;
    }

    public static List<User> getStatusData(Context ctx){
        List<User> items = new ArrayList<>();
        TypedArray photosArray = ctx.getResources().obtainTypedArray(R.array.contact_images);
        String namesArray[] = ctx.getResources().getStringArray(R.array.contact_names);
        String statusTimesArray[] = ctx.getResources().getStringArray(R.array.status_times);

        for (int i = 0; i < statusTimesArray.length; i++) {
            User contact = new User();
            contact.image = photosArray.getResourceId(i, -1);
            contact.name = namesArray[i];
            contact.imageDrw = ctx.getResources().getDrawable(contact.image);
            contact.statusTime = statusTimesArray[i];
            items.add(contact);
        }
        Collections.shuffle(items);
        photosArray.recycle();
        return items;
    }
}

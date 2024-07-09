package com.example;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class App extends TelegramLongPollingBot {


    private boolean screaming = false;
    private InlineKeyboardMarkup keyboardM1;
private InlineKeyboardMarkup keyboardM2;


    

    private long shangaID=1312004966;
    private long mainAccID=1191395987;
    private long secondAccID=1922256090;
    
    

  @Override
  public String getBotUsername() {
      return "rekkakurdBot";
  }

  @Override
  public String getBotToken() {
      return "6614729646:AAHonDMCMz7I8b1cKsvcA65NluxGHi_SskY";
  }

  public void sendText(Long who, String what){
    SendMessage sm = SendMessage.builder()
                     .chatId(who.toString()) //Who are we sending a message to
                     .text(what).build();    //Message content
    try {
         execute(sm);                        //Actually sending the message
    } catch (TelegramApiException e) {
         throw new RuntimeException(e);      //Any error will be printed here
    }
 }

  @Override
public void onUpdateReceived(Update update) {

    






    System.out.println(update);
    System.out.println(update.getMessage().getText());
    System.out.println(update.getMessage().getChatId());
    long updateID= update.getMessage().getChatId();
    String mes= update.getMessage().getText();
    String userN= update.getMessage().getFrom().getUserName();
    
    sendText(mainAccID, "user name:"+" userN \n user Message: "+ mes);

    if (updateID==mainAccID ) {
 
        sendText(shangaID, update.getMessage().getText());
        
    }
    else {
        sendText(mainAccID, update.getMessage().getText());
    }  
}

public static void main(String[] args) throws TelegramApiException {
  TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
  botsApi.registerBot(new App());

  
}


}
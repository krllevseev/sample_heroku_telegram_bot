package com;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by kirillevseev on 3/28/17.
 */
public class MainListener extends TelegramLongPollingBot {
    public void onUpdateReceived(Update update) {

        SendMessage sendMessage = new SendMessage();
        
        sendMessage.setChatId(update.getMessage().getChatId());
        sendMessage.setText(update.getMessage().getText());

        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace(); // TODO process this
        }

    }

    public String getBotUsername() {
        return "the_bot";
    }

    public String getBotToken() {
        return System.getenv("BOT_KEY1");
    }
}

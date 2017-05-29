package com;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Created by kirillevseev on 3/28/17.
 */
public class BotRunner {

    private static Logger log = Logger.getLogger(BotRunner.class.getName());

    public static void main(String[] args) {

        ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            LogManager.getLogManager().readConfiguration(
                    BotRunner.class.getResourceAsStream("/logging.properties"));
            telegramBotsApi.registerBot(new MainListener());
        } catch (TelegramApiException | IOException e) {
            log.log(Level.WARNING, "Issue on bot running:", e);
        }
    }
}


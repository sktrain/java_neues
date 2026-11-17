package ch05_api.http2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.TemporalAdjusters;
import java.util.Optional;

/**
 * Beispielprogramm für die Workshops "Best of Java 11 - 17 / 18 / 19" und das
 * Buch "Java – Die Neuerungen in Version 17 LTS, 18 und 19"
 *
 * @author Michael Inden
 *         <p>
 *         Copyright 2021/22 by Michael Inden
 */
public class Http2_REST_Call_Example
{
    public static void main(String[] args) 
    {
        // HTTP/2-API
        var httpClient = HttpClient.newHttpClient();

        // Stream mit monatlicher Schrittweite
        var startDay = LocalDate.of(2021, Month.JANUARY, 1);
        var endDay = LocalDate.of(2021, Month.OCTOBER, 1);
        Period stepOneMonth = Period.ofMonths(1);

        // DATESUNTIL
        startDay.datesUntil(endDay, stepOneMonth).forEach(localDate -> {

            // TEMPORALADJUSTERS
            LocalDate endOfMonth = localDate.with(TemporalAdjusters.lastDayOfMonth());

            // var seit Java 10 und Aufruf mit HTTP/2-API
            var optResponseBody = performGet(httpClient, endOfMonth);

            // OPTIONAL-Handling
            optResponseBody.ifPresentOrElse((value) -> System.out.println(endOfMonth + " reported " + value),
                                            () -> System.out.println("No data for " + endOfMonth));
        });
    }

    private static Optional<String> performGet(HttpClient httpClient, LocalDate desiredDate)
    {
        try
        {
            var httpRequest = createHttpRequestWithKey(desiredDate);

            var response = httpClient.send(httpRequest, BodyHandlers.ofString());
            String responseBody = response.body();

            return Optional.of(responseBody);
        }
        catch (Exception ex)
        {
            // in diesem Beispiel ausnahmsweise ignorieren
        }
        return Optional.empty();
    }

    private static HttpRequest createHttpRequestWithKey(LocalDate desiredDate)
    {
        var key = "5e9375c8c908bdc0d6e6a356ea14b860";
    
        return HttpRequest.newBuilder().GET()
                          .uri(URI.create("http://data.fixer.io/" + desiredDate + 
                                          "?symbols=CHF&access_key=" + key))
                          .build();
    }
}

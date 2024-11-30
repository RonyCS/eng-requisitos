package com.event.service;

import java.util.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EventServiceTest {

    private Map<String, Boolean> validParticipantsMap;
    private final Map<String, Boolean> emptyParticipantsMap = Collections.emptyMap();
    private String validStartDate;
    private String validEndDate;
    private int validParticipantsNumber;
    private double validCostPerParticipant;
    private String[] validParticipantsList;
    private String validSearchText;
    private int validMaxParticipants;

    @BeforeEach
    void setUp() {
        validParticipantsMap = new HashMap<>();
        validParticipantsMap.put("Alice", true);
        validParticipantsMap.put("Bob", false);
        validParticipantsMap.put("Charlie", true);

        validStartDate = "2024-11-01";
        validEndDate = "2024-11-10";

        validParticipantsNumber = 3;
        validCostPerParticipant = 100.0;

        validParticipantsList = new String[]{"Alice", "Bob", "Charlie"};
        validSearchText = "A";
        validMaxParticipants = 2;
    }

    @Nested
    class TestGetEventBudget {

        @Test
        void testValidParticipants() {
            double result = EventService.getEventBudget(validParticipantsNumber, validCostPerParticipant);
            assertEquals(300.0, result, "O custo do evento deve ser 300.");
        }

        @Test
        void testZeroOrNegativeParticipants() {
            assertEquals(0, EventService.getEventBudget(0, validCostPerParticipant), "O custo deve ser 0 quando o número de participantes for 0.");
            assertEquals(0, EventService.getEventBudget(-1, validCostPerParticipant), "O custo deve ser 0 quando o número de participantes for negativo.");
        }

        @Test
        void testInvalidCost() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                    EventService.getEventBudget(validParticipantsNumber, -50.0)
            );
            assertEquals("There should be a cost per participant", exception.getMessage());
        }
    }

    @Nested
    class TestGetParticipantsByName {

        @Test
        void testValidSearchText() {
            List<String> result = EventService.getParticipantsByName(Arrays.asList(validParticipantsList), validSearchText);
            assertTrue(result.contains("Alice"), "Should return 'Alice' when 'A' is searched.");
        }

        @Test
        void testEmptySearchText() {
            List<String> result = EventService.getParticipantsByName(Arrays.asList(validParticipantsList), "");
            assertTrue(result.isEmpty(), "The list should be empty when the searchText is empty.");
        }

        @Test
        void testNullParticipantsList() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                    EventService.getParticipantsByName(null, validSearchText)
            );
            assertEquals("A valid list of participants is expected", exception.getMessage());
        }
    }

    @Nested
    class TestValidateEventDate {

        @Test
        void testValidDates() {
            boolean result = EventService.validateEventDate(validStartDate, validEndDate);
            assertTrue(result, "Valid dates should pass the validation.");
        }

        @Test
        void testStartDateAfterEndDate() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                    EventService.validateEventDate(validEndDate, validStartDate)
            );
            assertEquals("A start date and end date is expected", exception.getMessage());
        }

        @Test
        void testNullDates() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                    EventService.validateEventDate(null, validEndDate)
            );
            assertEquals("Start date and end date must not be null.", exception.getMessage());
        }

        @Test
        void testEmptyDates() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                    EventService.validateEventDate("", validEndDate)
            );
            assertEquals("Start date and end date must not be empty.", exception.getMessage());
        }

        @Test
        void testInvalidDateFormat() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                    EventService.validateEventDate("01-11-2024", validEndDate)
            );
            assertEquals("Dates must be in the format 'yyyy-MM-dd'.", exception.getMessage());
        }
    }

    @Nested
    class TestGetParticipantsReport {

        @Test
        void testValidParticipants() {
            List<String> result = EventService.getParticipantsReport(validParticipantsMap);
            assertTrue(result.contains("Alice"), "Should return 'Alice' as a confirmed participant.");
            assertTrue(result.contains("Charlie"), "Should return 'Charlie' as a confirmed participant.");
            assertFalse(result.contains("Bob"), "Should not return 'Bob' since his presence is not confirmed.");
        }

        @Test
        void testEmptyParticipantsMap() {
            List<String> result = EventService.getParticipantsReport(emptyParticipantsMap);
            assertTrue(result.isEmpty(), "The participants list is empty.");
        }

        @Test
        void testNullParticipantsMap() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                    EventService.getParticipantsReport(null)
            );
            assertEquals("The participantsMap must not be null", exception.getMessage());
        }
    }

    @Nested
    class TestEventIsFull {

        @Test
        void testEventNotFull() {
            boolean result = EventService.eventIsFull(validParticipantsMap, 4);
            assertFalse(result, "The event should not be full.");
        }

        @Test
        void testEventFull() {
            validMaxParticipants = 2;
            validParticipantsMap.put("David", true);
            boolean result = EventService.eventIsFull(validParticipantsMap, validMaxParticipants);
            assertTrue(result, "The event should be full.");
        }

        @Test
        void testNullParticipantsMap() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                    EventService.eventIsFull(null, validMaxParticipants)
            );
            assertEquals("The participantsMap must not be null", exception.getMessage());
        }

        @Test
        void testEmptyParticipantsMap() {
            boolean result = EventService.eventIsFull(emptyParticipantsMap, validMaxParticipants);
            assertFalse(result, "The event should not be full when the participants list is empty.");
        }
    }
}
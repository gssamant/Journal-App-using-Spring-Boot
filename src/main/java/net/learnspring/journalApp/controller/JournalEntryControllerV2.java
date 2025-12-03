package net.learnspring.journalApp.controller;

import net.learnspring.journalApp.entity.JournalEntry;
import net.learnspring.journalApp.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll() {
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry newEntry) {
        newEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(newEntry);
        return true;
    }

    @GetMapping("id/{requestId}")
    public JournalEntry requestJournal(@PathVariable ObjectId requestId) {
        return null;
    }

    @DeleteMapping("id/{requestId}")
    public JournalEntry deleteRequest(@PathVariable ObjectId requestId) {
        return null;
    }

    @PutMapping("id/{requestId}")
    public JournalEntry updateRequest(@PathVariable ObjectId requestId, @RequestBody JournalEntry newEntry) {
        return null;
    }
}

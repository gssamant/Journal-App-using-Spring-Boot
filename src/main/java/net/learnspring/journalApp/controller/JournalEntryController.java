package net.learnspring.journalApp.controller;

import net.learnspring.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/_journal")
public class JournalEntryController {

    private Map<ObjectId, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry newEntry) {
        journalEntries.put(newEntry.getId(), newEntry);
        return true;
    }

    @GetMapping("id/{requestId}")
    public JournalEntry requestJournal(@PathVariable ObjectId requestId) {
        return journalEntries.get(requestId);
    }

    @DeleteMapping("id/{requestId}")
    public JournalEntry deleteRequest(@PathVariable ObjectId requestId) {
        return journalEntries.remove(requestId);
    }

    @PutMapping("id/{requestId}")
    public JournalEntry updateRequest(@PathVariable ObjectId requestId, @RequestBody JournalEntry newEntry) {
        return journalEntries.put(requestId, newEntry);
    }
}

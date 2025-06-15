package pl.coderslab.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.domain.Book;
import pl.coderslab.domain.Publisher;
import pl.coderslab.repository.PublisherRepository;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

    PublisherRepository publisherRepository;

    public PublisherController(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/{id}")
    public Publisher get(@PathVariable Long id) {
        return publisherRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Publisher not found"));
    }

    @PostMapping
    public Publisher create(@RequestBody Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        publisherRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Publisher update(@PathVariable Long id, @RequestBody Publisher publisher) {
        Publisher publisherFromDb = publisherRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Publisher not found"));

        publisherFromDb.setName(publisher.getName());
        publisherFromDb.setCity(publisher.getCity());
        publisherFromDb.setAddress(publisher.getAddress());
        publisherFromDb.setZipCode(publisher.getZipCode());

        return publisherRepository.save(publisherFromDb);
    }
}

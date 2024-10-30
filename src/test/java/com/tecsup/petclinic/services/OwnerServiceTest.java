package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;
import com.tecsup.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Slf4j
@SpringBootTest
public class OwnerServiceTest {

	@Mock
	private OwnerRepository ownerRepository;

	@InjectMocks
	private OwnerServiceImpl ownerService;

	private Owner owner;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		owner = new Owner(1, "Jaime", "Smith", "123 Main St", "Cityville", "123456789");
	}

	// 1. Prueba de Creación de Propietario
	@Test
	public void testCreateOwner() {
		when(ownerRepository.save(any(Owner.class))).thenReturn(owner);

		Owner createdOwner = ownerService.create(owner);

		assertNotNull(createdOwner);
		assertEquals(owner.getId(), createdOwner.getId());
		assertEquals(owner.getFirstName(), createdOwner.getFirstName());
		verify(ownerRepository, times(1)).save(owner);
	}

	// 2. Prueba de Actualización de Propietario
	@Test
	public void testUpdateOwner_OwnerExists() {
		when(ownerRepository.existsById(owner.getId())).thenReturn(true);
		when(ownerRepository.save(owner)).thenReturn(owner);

		Owner updatedOwner = ownerService.update(owner);

		assertNotNull(updatedOwner);
		assertEquals(owner.getId(), updatedOwner.getId());
		verify(ownerRepository, times(1)).save(owner);
	}

	@Test
	public void testUpdateOwner_OwnerNotFound() {
		when(ownerRepository.existsById(owner.getId())).thenReturn(false);

		Exception exception = assertThrows(OwnerNotFoundException.class, () -> {
			ownerService.update(owner);
		});

		assertEquals("Owner not found", exception.getMessage());
		verify(ownerRepository, never()).save(owner);
	}

	// 3. Prueba de Búsqueda de Propietario por ID
	@Test
	public void testFindOwnerById_OwnerExists() {
		when(ownerRepository.findById(owner.getId())).thenReturn(Optional.of(owner));

		Owner foundOwner = ownerService.findById(owner.getId());

		assertNotNull(foundOwner);
		assertEquals(owner.getId(), foundOwner.getId());
		verify(ownerRepository, times(1)).findById(owner.getId());
	}

	@Test
	public void testFindOwnerById_OwnerNotFound() {
		when(ownerRepository.findById(owner.getId())).thenReturn(Optional.empty());

		Exception exception = assertThrows(OwnerNotFoundException.class, () -> {
			ownerService.findById(owner.getId());
		});

		assertEquals("Owner not found", exception.getMessage());
	}

	// 4. Prueba de Eliminación de Propietario
	@Test
	public void testDeleteOwner_OwnerExists() {
		when(ownerRepository.findById(owner.getId())).thenReturn(Optional.of(owner));

		assertDoesNotThrow(() -> ownerService.delete(owner.getId()));
		verify(ownerRepository, times(1)).delete(owner);
	}

	@Test
	public void testDeleteOwner_OwnerNotFound() {
		when(ownerRepository.findById(owner.getId())).thenReturn(Optional.empty());

		Exception exception = assertThrows(OwnerNotFoundException.class, () -> {
			ownerService.delete(owner.getId());
		});

		assertEquals("Owner not found", exception.getMessage());
		verify(ownerRepository, never()).delete(any(Owner.class));
	}
}

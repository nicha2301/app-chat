import { yupResolver } from '@hookform/resolvers/yup';
import React, { useState } from 'react';
import { useForm } from 'react-hook-form';
import * as Yup from 'yup';
import FormProvider from '../../components/hook-form/FormProvider';
import { Alert, Button, IconButton, InputAdornment, Stack } from '@mui/material';
import { RHFTextField } from '../../components/hook-form';
import { Eye, EyeSlash } from 'phosphor-react';
import { useNavigate } from 'react-router-dom';

const RegisterForm = () => {
  const [successMessage, setSuccessMessage] = useState('');
  const [showPassword, setShowPassword] = useState(false);
  const navigate = useNavigate(); 

  //validation rules 
  const registerSchema = Yup.object().shape({
    fullName: Yup.string().required('Full Name is required'),
    username: Yup.string().required('Username is required'),
    password: Yup.string().required('Password is required')
  });


  const methods = useForm({
    resolver: yupResolver(registerSchema)
  });

  const { reset, setError, handleSubmit, formState: { errors, isSubmitting, isSubmitSuccessful } }
    = methods;

  const onSubmit = async (data) => {
    try {
      //submit data to backend
      const response = await fetch('http://localhost:8080/api/users', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });

      if (!response.ok) {
        throw new Error('Failed to register. Please try again.');
      }

      const result = await response.json();
      console.log('Registration successful:', result);

      setSuccessMessage('Registration successful! Redirecting to login...');
      
      setTimeout(() => {
        navigate('/auth/login');
      }, 2000); 

    } catch (error) {
      console.log(error);
      reset();
      setError('afterSubmit', {
        ...error,
        message: error.message
      })
    }
  }

  return (
    <FormProvider methods={methods} onSubmit={handleSubmit(onSubmit)}>
      <Stack spacing={3}>
        {!!errors.afterSubmit && <Alert severity='error'>{errors.afterSubmit.message}</Alert>}
        {!!successMessage && <Alert severity='success'>{successMessage}</Alert>}
        <RHFTextField name="fullName" label='Full Name' />
        <RHFTextField name="username" label='Username' />
        <RHFTextField name='password' label='Password' type={showPassword ? 'text' : 'password'}
          InputProps={{
            endAdornment: (
              <InputAdornment>
                <IconButton onClick={() => {
                  setShowPassword(!showPassword);
                }}>
                  {showPassword ? <Eye /> : <EyeSlash />}
                </IconButton>
              </InputAdornment>
            )
          }} />
        <Button fullWidth color='inherit' size='large' type='submit' variant='contained'
          sx={{
            bgcolor: 'text.primary', color: (theme) => theme.palette.mode === 'light' ?
              'common.white' : 'grey.800',
            '&:hover': {
              bgcolor: 'text.primary',
              color: (theme) => theme.palette.mode === 'light' ? 'common.white' : 'grey.800',
            }
          }}>Create Account</Button>
      </Stack>

    </FormProvider>
  )
}

export default RegisterForm
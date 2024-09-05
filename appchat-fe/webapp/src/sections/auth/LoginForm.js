import React, { useState } from 'react';
import * as Yup from 'yup';
import { useForm } from 'react-hook-form';
import FormProvider from '../../components/hook-form/FormProvider'
import { yupResolver } from '@hookform/resolvers/yup';
import { Alert, Button, IconButton, InputAdornment, Link, Stack } from '@mui/material';
import { RHFTextField } from '../../components/hook-form';
import { Eye, EyeSlash } from 'phosphor-react';
import { Link as RouterLink, useNavigate } from 'react-router-dom';

const LoginForm = () => {
  const [successMessage, setSuccessMessage] = useState('');
  const [showPassword, setShowPassword] = useState(false);
  const navigate = useNavigate();

  //validation rules 
  const loginSchema = Yup.object().shape({
    username: Yup.string().required('Username is required'),
    password: Yup.string().required('Password is required')
  });

  const methods = useForm({
    resolver: yupResolver(loginSchema)
  });

  const { reset, setError, handleSubmit, formState: { errors, isSubmitting, isSubmitSuccessful } }
    = methods;

  const onSubmit = async (data) => {
    try {
      const response = await fetch('http://localhost:8080/api/auth/token', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });

      if (!response.ok) {
        throw new Error('Failed to log in.');
      }

      const result = await response.json();

      // Lưu token vào localStorage
      localStorage.setItem('authToken', result.result.token);

      const getUser = await fetch('http://localhost:8080/api/users/info', {
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': 'Bearer ' + result.result.token
        }
      });

      const userData = await getUser.json();

      console.log(userData)

      localStorage.setItem('user', JSON.stringify(userData.result));

      setSuccessMessage('Login successful! Redirecting to app...');

      setTimeout(() => {
        navigate('/app');
      }, 2000);

    } catch (error) {
      reset();
      setError('afterSubmit', {
        ...error,
        message: error.message
      });
    }
  };


  return (
    <FormProvider methods={methods} onSubmit={handleSubmit(onSubmit)}>
      <Stack spacing={3}>
        {!!errors.afterSubmit && <Alert severity='error'>{errors.afterSubmit.message}</Alert>}
        {!!successMessage && <Alert severity='success'>{successMessage}</Alert>}
        <RHFTextField name='username' label='Username' />
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
      </Stack>
      <Stack alignItems={'flex-end'} sx={{ my: 2 }}>
        <Link component={RouterLink} to='/auth/reset-password'
          variant='body2' color='inherit' underline='always'>Forgot Password?</Link>
      </Stack>
      <Button fullWidth color='inherit' size='large' type='submit' variant='contained'
        sx={{
          bgcolor: 'text.primary', color: (theme) => theme.palette.mode === 'light' ?
            'common.white' : 'grey.800',
          '&:hover': {
            bgcolor: 'text.primary',
            color: (theme) => theme.palette.mode === 'light' ? 'common.white' : 'grey.800',
          }
        }}>Login</Button>
    </FormProvider>
  )
}

export default LoginForm